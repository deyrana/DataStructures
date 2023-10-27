package graph;

import java.util.Arrays;

public class MinimumSpanningTree {

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
		
		
		int [] parent = primMST(g);
		printMST(g, parent);
		
	}

	public static void printMST(Graph g, int[] parent) {
		int V = g.getV();
		int[][] graph = g.getAdjMat();
		System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t"+ graph[i][parent[i]]);
		
	}

	/* ALGORITHM
	 * 
	 * 1. Create a parent array to store parent vertex for the given vertex i
	 * 2. Create a key array to store the minimum weight of edge to vertex i from its parent in parent array
	 * 3. Create a boolean array mstSet to keep track of all the vertices already included in MST
	 * 4. Initialize key as 0 and parent as -1 for starting vertex (0).
	 * 5. Now loop for V-1 to calculate all the edges req in MST
	 * 6. for each loop, find the edge with minimum weight in key array for vertices not included in mstSet
	 * 7. Now update key values of neighbors of selected vertex if neighbor not visited and key(neighbor) > weight of edge 
	 * 	  between neighbor and selected vertex
	 * 8. Also update the parent of neighbor to selected vertex. 
	 * 
	 * */
	public static int[] primMST(Graph g) {
		int V = g.getV();
		int[][] adjMat = g.getAdjMat();
		int[] parent = new int[V], key = new int[V];
		boolean mstSet[] = new boolean[V];

		Arrays.fill(key, Integer.MAX_VALUE);

		key[0] = 0;
		parent[0] = -1;

		for (int e = 0; e < V - 1; e++) {

			int u = minKey(key, mstSet, V);
			if (u != -1) {
				mstSet[u] = true;
				for (int v = 0; v < V; v++) {
					if (adjMat[u][v] != Integer.MAX_VALUE && !mstSet[v] && adjMat[u][v] < key[v]) {
						key[v] = adjMat[u][v];
						parent[v] = u;
					}
				}
			}

		}

		return parent;
	}

	public static int minKey(int[] key, boolean[] mstSet, int V) {
		int minIndex = -1, minKey = Integer.MAX_VALUE;
		for (int i = 0; i < V; i++) {
			if (!mstSet[i] && key[i] < minKey) {
				minKey = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
