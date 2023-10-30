package graph;

import java.util.Arrays;

public class MinimumProductTree {

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.setAdjMat(new int[][] { 
			{ 0, 2, Integer.MAX_VALUE, 6, Integer.MAX_VALUE }, 
			{ 2, 0, 3, 8, 5 }, 
			{ Integer.MAX_VALUE, 3, 0, Integer.MAX_VALUE, 7 }, 
			{ 6, 8, Integer.MAX_VALUE, 0, 9 },
			{ Integer.MAX_VALUE, 5, 7, 9, 0 } });
		
		

		int[] parent = minimumProductTree(g);
		MinimumSpanningTree.printMST(g, parent);

		int[] parentPrimMST = MinimumSpanningTree.primMST(g);
		MinimumSpanningTree.printMST(g, parentPrimMST);

	}

	public static int[] minimumProductTree(Graph g) {
		int V = g.getV();
		double[][] logGraph = new double[V][V];
		int[][] adjMat = g.getAdjMat();

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (adjMat[i][j] == Integer.MAX_VALUE) {
					logGraph[i][j] = Double.MAX_VALUE;
				} else if (adjMat[i][j] == 0) {
					logGraph[i][j] = 0;
				} else {
					logGraph[i][j] = Math.log(adjMat[i][j]);
				}
			}
		}

		int[] parent = primsMST(logGraph, V);

		return parent;
	}

	private static int[] primsMST(double[][] adjMatModGra, int V) {
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];

		Arrays.fill(key, Integer.MAX_VALUE);
		parent[0] = -1;
		key[0] = 0;

		for (int e = 0; e < V - 1; e++) {
			int u = findMinKey(mstSet, key, V);
			if (u != -1) {
				mstSet[u] = true;
				for (int v = 0; v < V; v++) {
					if (adjMatModGra[u][v] != Double.MAX_VALUE && !mstSet[v] && adjMatModGra[u][v] < key[v]) {
						key[v] = (int) adjMatModGra[u][v];
						parent[v] = u;
					}
				}
			}
		}

		return parent;
	}

	private static int findMinKey(boolean[] mstSet, int[] key, int V) {
		int minIndex = -1;
		int minKey = Integer.MAX_VALUE;
		for (int i = 0; i < V; i++) {
			if (!mstSet[i] && key[i] < minKey) {
				minKey = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
