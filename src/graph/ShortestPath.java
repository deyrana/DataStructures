package graph;

public class ShortestPath {

	public static void main(String[] args) {

		Graph g = new Graph(9);

		g.addEdge(0, 1, 4);
		g.addEdge(1, 0, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(7, 0, 8);

		g.addEdge(1, 7, 11);
		g.addEdge(7, 1, 11);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 1, 8);

		g.addEdge(7, 6, 1);
		g.addEdge(6, 7, 1);
		g.addEdge(7, 8, 7);
		g.addEdge(8, 7, 7);

		g.addEdge(2, 8, 2);
		g.addEdge(8, 2, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7);
		g.addEdge(2, 5, 4);
		g.addEdge(5, 2, 4);

		g.addEdge(8, 6, 6);
		g.addEdge(6, 8, 6);

		g.addEdge(6, 5, 2);
		g.addEdge(5, 6, 2);

		g.addEdge(3, 5, 14);
		g.addEdge(5, 3, 14);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 3, 9);

		g.addEdge(4, 5, 10);
		g.addEdge(5, 4, 10);

		int[] dist = dijkstra(g, 0);
		System.out.println("dijkstra - ");
//		for (int i = 0; i < 9; i++) {
//			System.out.print(dist[i] + " ");
//		}
		
		printArr(dist, g.getV());
		System.out.println();
		System.out.println("bellmanFord - ");
		dist = bellmanFord(g, 0);
		printArr(dist, g.getV());

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
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {
			boolean flag = false;
			for (int u = 0; u < V; u++) {
				for (int v = 0; v < V; v++) {
					if (adjMat[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
						dist[v] = Integer.min(dist[v], dist[u] + adjMat[u][v]);
						flag = true;
					}
				}
			}
			
			if(!flag) {
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
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int vert = 0; vert < V; vert++) {
			int u = minDist(dist, sptSet, V);

			sptSet[u] = true;

			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && adjMat[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
					dist[v] = Integer.min(dist[u] + adjMat[u][v], dist[v]);
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
	
	public static void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

}
