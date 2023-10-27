package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class GraphPractice {

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

		int level = findLevel(g, 3, 4);
		System.out.println("level=> " + level);

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
