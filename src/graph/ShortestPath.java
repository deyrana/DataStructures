package graph;

import java.util.Arrays;

public class ShortestPath {

	public static void main(String[] args) {

//		Graph g = new Graph(9);
//
//		g.addEdge(0, 1, 4);
//		g.addEdge(1, 0, 4);
//		g.addEdge(0, 7, 8);
//		g.addEdge(7, 0, 8);
//
//		g.addEdge(1, 7, 11);
//		g.addEdge(7, 1, 11);
//		g.addEdge(1, 2, 8);
//		g.addEdge(2, 1, 8);
//
//		g.addEdge(7, 6, 1);
//		g.addEdge(6, 7, 1);
//		g.addEdge(7, 8, 7);
//		g.addEdge(8, 7, 7);
//
//		g.addEdge(2, 8, 2);
//		g.addEdge(8, 2, 2);
//		g.addEdge(2, 3, 7);
//		g.addEdge(3, 2, 7);
//		g.addEdge(2, 5, 4);
//		g.addEdge(5, 2, 4);
//
//		g.addEdge(8, 6, 6);
//		g.addEdge(6, 8, 6);
//
//		g.addEdge(6, 5, 2);
//		g.addEdge(5, 6, 2);
//
//		g.addEdge(3, 5, 14);
//		g.addEdge(5, 3, 14);
//		g.addEdge(3, 4, 9);
//		g.addEdge(4, 3, 9);
//
//		g.addEdge(4, 5, 10);
//		g.addEdge(5, 4, 10);
//
		
		
//		Graph g = new Graph(4);
//		g.addEdge(0, 1, 0);
//		g.addEdge(0, 2, 3);
//		g.addEdge(0, 3, 3);
//		g.addEdge(1, 2, 0);
//		g.addEdge(2, 3, 0);
//		
//		g.printAdjMat();
//		
//		int[] dist = dijkstra(g, 1);
//		System.out.println("dijkstra - ");
//		printArr(dist, g.getV());
//		System.out.println();
//		System.out.println("bellmanFord - ");
//		dist = bellmanFord(g, 0);
//		printArr(dist, g.getV());
		
//		Graph g = new Graph(4);
//		
//		g.addEdge(0, 1, 5);
//		g.addEdge(0, 3, 10);
//		g.addEdge(1, 2, 3);
//		g.addEdge(2, 3, 1);
		
		Graph g = new Graph(4);
		
		g.addEdge(0, 1, -5);
		g.addEdge(0, 2, 2);
		g.addEdge(0, 3, 3);
		g.addEdge(1, 2, 4);
		g.addEdge(2, 3, 1);
		
		
//		int distPair[][] = floydWarshall(g);
		
		int distPair[][] = johnson(g);
		printArr2D(distPair, g.getV());

	}

	/* ALGORITHM
	 * 
	 * 1. Create a new graph by adding a new vertex and assigning weights from new vertex to every other vertex as zero.
	 * 2. Using BellmanFord calculate shortest distance of each node from new vertex.
	 * 3. re-weight the edges of old graph using distance from BellmanFord 
	 * 4. Now calculate shortest path for all vertices using Dijkstra.
	 * 5. Now revert the weights of the graph edges as done earlier
	 * 
	 * */
	public static int[][] johnson(Graph g) {
		int V = g.getV();
		int[][] adjMat = g.getAdjMat();
		int[][] result = new int[V][V];

		int[][] newAdjMat = addNewVertex(adjMat, V);
		Graph newGraph = new Graph(V + 1);
		newGraph.setAdjMat(newAdjMat);

		int[] distBellman = bellmanFord(newGraph, V);

		// re-weight edges
		for (int u = 0; u < V; u++) {
			for (int v = 0; v < V; v++) {
				if (adjMat[u][v] != Integer.MAX_VALUE)
					adjMat[u][v] += distBellman[u] - distBellman[v];
			}
		}

		g.setAdjMat(adjMat);

		for (int u = 0; u < V; u++) {
			int[] distDijk = dijkstra(g, u);

			for (int v = 0; v < V; v++) {
				if (distDijk[v] != Integer.MAX_VALUE)
					distDijk[v] += distBellman[v] - distBellman[u];
			}

			result[u] = distDijk;
		}

		return result;
	}


	private static int[][] addNewVertex(int[][] adjMat, int V) {

		int[][] newAdjMat = new int[V + 1][V + 1];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				newAdjMat[i][j] = adjMat[i][j];
				newAdjMat[i][V] = Integer.MAX_VALUE;
			}
		}

		return newAdjMat;
	}


	/* ALGORITHM
	 * 
	 * 1. Create a distPair 2d array representing shortest distance between 2 vertices u and v
	 * 2. Initialize distPair with 0 for u==v, INFINITE for no edges and weight for edges where edge is present
	 * 3. Now select an intermediate node k by looping over all vertices
	 * 4. Now pick all pair of vertices (u,v) in 2d array
	 * 5. update distance between u and v if distance of u,v is more than dist(u,k) + dist(k,u)
	 * 6. Return distPair 2d array
	 * 
	 * */
	public static int[][] floydWarshall(Graph g) {

		int V = g.getV();
		int[][] adjMat = g.getAdjMat();
		int distPair[][] = new int[V][V];

		// Initialize 2d array
		for (int u = 0; u < V; u++) {
			for (int v = 0; v < V; v++) {
				if (u == v)
					distPair[u][v] = 0;
				else
					distPair[u][v] = adjMat[u][v];
			}
		}

		for (int k = 0; k < V; k++) {
			for (int u = 0; u < V; u++) {
				for (int v = 0; v < V; v++) {
					if (distPair[u][k] != Integer.MAX_VALUE && distPair[k][v] != Integer.MAX_VALUE) {
						distPair[u][v] = Integer.min(distPair[u][v], distPair[u][k] + distPair[k][v]);
					}
				}
			}
		}

		return distPair;
	}

	/* ALGORITHM
	 * 
	 * 1. Create a dist array to store distance of nodes from source node
	 * 2. Initialize dist array with 0 for source node and Infinite for other nodes
	 * 3. Now loop over all the vertices and loop over neighbors of selected vertex.
	 * 4. For every neighbor, update the distance array if distance of selected node + weight of edge 
	 * 	  between select node and neighbor is less than distance of neighbor in the dist array.
	 * 5. Now repeat this for all nodes and all edges V-1 times.
	 * 6. return the final dist array. 
	 * 
	 * */
	public static int[] bellmanFord(Graph g, int src) {
		int[][] adjMat = g.getAdjMat();
		int V = g.getV();
		int[] dist = new int[V];

		// initialize
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			boolean flag = false;
			for (int u = 0; u < V; u++) {
				for (int v = 0; v < V; v++) {
					if (adjMat[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE) {
						dist[v] = Integer.min(dist[v], dist[u] + adjMat[u][v]);
						flag = true;
					}
				}
			}

			if (!flag) {
				return dist;
			}

		}

		return dist;
	}

	/* ALGORITHM
	 * 
	 * 1. create a distance array which keeps the distance(dist[i]) between source node and destination node i
	 * 2. create a shortest path tree set (sptSet) tracking all the visited nodes whose distance has been finalized
	 * 3. Initialize dist array with infinite and sptSet with false in the beginning.
	 * 4. Now set the distance of the source as 0 in dist array
	 * 5. Now loop through all the vertices in the graph
	 * 6. From the given nodes select the one node with least distance and not visited (!sptSet[i])
	 * 7. Mark the selected node as visited in sptSet array
	 * 8. Now loop for all the neighbors of the selected node
	 * 9. For every neighbor, update the distance array if neighbor is not visited and 
	 *    distance of selected node + weight of edge between select node and neighbor is less than 
	 *    distance of neighbor in the dist array.
	 * 10. Return the distance array.
	 * 
	 * */
	public static int[] dijkstra(Graph g, int src) {

		int[][] adjMat = g.getAdjMat();
		int V = g.getV();

		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];

		// initialize
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(sptSet, false);

		dist[src] = 0;

		for (int vert = 0; vert < V; vert++) {
			int u = minDist(dist, sptSet, V);

			if (u != -1) {
				sptSet[u] = true;

				for (int v = 0; v < V; v++) {
					if (!sptSet[v] && adjMat[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE) {
						dist[v] = Integer.min(dist[u] + adjMat[u][v], dist[v]);
					}
				}
			}

		}

		return dist;
	}

	public static int minDist(int[] dist, boolean[] sptSet, int V) {
		int minDist = Integer.MAX_VALUE, minInd = -1;

		for (int v = 0; v < V; v++) {
			if (!sptSet[v] && dist[v] < minDist) {
				minDist = dist[v];
				minInd = v;
			}
		}
		return minInd;
	}
	
	public static void printArr(int dist[], int V) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	public static void printArr2D(int dist[][], int V) {
		System.out.println("Vertex\t\tDistance from Source");
		for (int i = 0; i < V; ++i) {
			System.out.print(i + "\t\t");
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == Integer.MAX_VALUE) {
					System.out.print("I\t\t");
				} else
					System.out.print(dist[i][j] + "\t\t");
			}
			System.out.println();
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
