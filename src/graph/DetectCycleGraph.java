package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DetectCycleGraph {

	public static void main(String[] args) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(2, 0);

		Boolean isCycle = detectCycle(g);
		System.out.println("isCycle - " + isCycle);
		
		Boolean isCycleMat = detectCycleMatrix(g);
		System.out.println("isCycleMat - " + isCycleMat);

	}

	/* ALGORITHM
	 * 
	 * 1. Create a visited and path array
	 * 2. visited keep tracks of visited nodes while path keeps track of all nodes traversed in a path
	 * 3. Loop over all the vertices and check for loop using util function when node is not visited
	 * 4. even if one node returns true then cycle present
	 * 5. else return false - no cycle present
	 * 
	 * */
	public static Boolean detectCycle(Graph g) {

		int V = g.getV();
		LinkedList<Integer>[] adj = g.getAdj();
		ArrayList<Integer> visited = new ArrayList<>(), path = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			if (!visited.contains(i) && detectCycleUtil(adj, i, V, visited, path)) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	/* ALGORITHM
	 * 
	 * 1. Since node is visited and included in path, enter this node in visited and path arrays
	 * 2. Loop over all the neighbors of node we are visiting
	 * 3. if the neighbors nodes are not visited check for loop in them (DFS)
	 * 4. if loop found in neighbor then return true
	 * 5. else if the neighbor has already been visited and also present in path, then loop found. Return true
	 * 6. Else while returning from function remove the node from path array and return false
	 * 
	 * */
	public static Boolean detectCycleUtil(LinkedList<Integer>[] adj, Integer node, int V, ArrayList<Integer> visited,
			ArrayList<Integer> path) {

		visited.add(node);
		path.add(node);

		for (Integer neighbour : adj[node]) {
			if (!visited.contains(neighbour)) {
				if (detectCycleUtil(adj, neighbour, V, visited, path))
					return Boolean.TRUE;
			} else if (path.contains(neighbour))
				return Boolean.TRUE;
		}

		path.remove(node);

		return Boolean.FALSE;
	}
	
	
	public static Boolean detectCycleMatrix(Graph g) {

		int V = g.getV();
		int[][] adjMat = g.getAdjMat();

		boolean[] visited = new boolean[V], path = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i] && detectCycleUtil(adjMat, i, V, visited, path)) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	public static boolean detectCycleUtil(int[][] adjMat, int node, int V, boolean[] visited, boolean[] path) {
		visited[node] = true;
		path[node] = true;

		for (int v = 0; v < V; v++) {
			if (adjMat[node][v] != Integer.MAX_VALUE && v != node) {
				if (!visited[v]) {
					if (detectCycleUtil(adjMat, v, V, visited, path)) {
						return Boolean.TRUE;
					}
				} else if (path[v]) {
					return Boolean.TRUE;
				}
			}
		}
		path[node] = false;
		return Boolean.FALSE;
	}
	
	

}
