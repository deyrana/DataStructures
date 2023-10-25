package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class GraphTraversal {

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);

		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(1, 3);

		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(2, 4);

		g.addEdge(3, 1);
		g.addEdge(3, 4);

		g.addEdge(4, 2);
		g.addEdge(4, 3);

		BFS(g, 3);
		BFSmat(g,3);
//		DFS(g, 0);

	}



	public static void DFS(Graph g, int startNode) {
		int V = g.getV();
		LinkedList<Integer> adj[] = g.getAdj();
		Vector<Integer> visited = new Vector<>(V);

		Stack<Integer> st = new Stack<>();
		st.add(startNode);
		visited.add(startNode);

		while (!st.isEmpty()) {
			int vert = st.pop();
			System.out.print(vert + " ");

			Iterator<Integer> it = adj[vert].iterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited.contains(n)) {
					visited.add(n);
					st.add(n);
				}
			}
		}
		System.out.println();
	}

	public static void BFS(Graph g, int startNode) {

		int V = g.getV();
		LinkedList<Integer> adj[] = g.getAdj();
		Vector<Integer> visited = new Vector<>(V);

		Queue<Integer> q = new LinkedList<>();
		q.add(startNode);
		visited.add(startNode);

		while (!q.isEmpty()) {
			int vert = q.poll();
			System.out.print(vert + " ");
			Iterator<Integer> it = adj[vert].iterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited.contains(n)) {
					visited.add(n);
					q.add(n);
				}
			}
		}
		System.out.println();
	}
	
	private static void BFSmat(Graph g, int startNode) {
		int V = g.getV();
		Integer[][] adjMat = g.getAdjMat();
		Vector<Integer> visited = new Vector<>(V);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(startNode);
		visited.add(startNode);
		
		while(!q.isEmpty()) {
			int vert = q.poll();
			System.out.print(vert + " ");
			
			for (int i = 0; i < V; i++) {
				Integer n = adjMat[vert][i];
				if (n != null && !visited.contains(i)) {
					visited.add(i);
					q.add(i);
				}
			}
		}
		System.out.println();
		
	}
}
