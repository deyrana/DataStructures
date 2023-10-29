package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class GraphPractice {

	public static void main(String[] args) {

//		Graph g = new Graph(5);
//		g.addEdge(0, 1);
//		g.addEdge(0, 2);
//
//		g.addEdge(1, 0);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//
//		g.addEdge(2, 0);
//		g.addEdge(2, 1);
//		g.addEdge(2, 4);
//
//		g.addEdge(3, 1);
//		g.addEdge(3, 4);
//
//		g.addEdge(4, 2);
//		g.addEdge(4, 3);
//
//		int level = findLevel(g, 3, 4);
//		System.out.println("level=> " + level);
		
		int[][] roads = new int[][]{
			 {0, 1, 1, 100, 0, 0},
	         {1, 0, 1, 0, 0, 0},
	         {1, 1, 0, 0, 0, 0},
	         {100, 0, 0, 0, 2, 2},
	         {0, 0, 0, 2, 0, 2},
	         {0, 0, 0, 2, 2, 0}};
	         
        int minCost = findMinCost(roads);
        System.out.println("minCost - "+minCost);

	}

	private static int findMinCost(int[][] roads) {
		int V = roads[0].length;
		int[] parent = new int[V], key = new int[V];
		boolean mstSet[] = new boolean[V];
		
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0] = 0; 
		parent[0] = -1;
		
		for(int i=0; i< V-1; i++) {
			int u = minKey(key, mstSet, V);
			if(u!=-1) {
				mstSet[u] = true;
				for(int v=0; v<V; v++) {
					if(roads[u][v] != 0 && !mstSet[v] && key[v] > roads[u][v]) {
						key[v] = roads[u][v];
						parent[v] = u;
					}
				}
			}
		}
		int cost = 0;
		for(int i=1; i<V; i++) {
			cost+=key[i];
		}
		
		return cost;
	}

	private static int minKey(int[] key, boolean[] mstSet, int V) {
		int minIndex = -1, minKey = Integer.MAX_VALUE;
		
		for(int v = 0; v < V; v++) {
			if(!mstSet[v] && minKey > key[v]) {
				minKey = key[v];
				minIndex = v;
			}
		}
		
		return minIndex;
	}

	private static int findLevel(Graph g, int startNode, int key) {

		int V = g.getV();
		LinkedList<Integer>[] adj = g.getAdj();
		int level = 0;
		Queue<Integer> q = new LinkedList<>();
		Vector<Integer> visited = new Vector<>(V);
		q.add(startNode);
		q.add(null);
		visited.add(startNode);

		while (!q.isEmpty()) {
			Integer node = q.poll();
			if (node != null) {
				// Key vertex found
				if (node == key) {
					return level;
				}
				Iterator<Integer> it = adj[node].iterator();

				while (it.hasNext()) {
					Integer n = it.next();
					if (!visited.contains(n)) {
						visited.add(n);
						q.add(n);
					}
				}
			} else {
				++level;
				if (!q.isEmpty())
					q.add(null);
			}
		}

		return -1;
	}

}
