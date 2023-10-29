package graph;

import java.util.Arrays;

public class MultiStageGraph {

	public static void main(String[] args) {
		Graph g = new Graph(8);
		
		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 2);
		g.addEdge(0, 3, 5);
		g.addEdge(1, 4, 4);
		g.addEdge(1, 5, 11);
		g.addEdge(2, 4, 9);
		g.addEdge(2, 5, 5);
		g.addEdge(2, 6, 16);
		g.addEdge(3, 6, 2);
		g.addEdge(4, 7,18);
		g.addEdge(5, 7, 13);
		g.addEdge(6, 7, 2);
		
		int cost = findShortestPath(g);
		System.out.println("Minimum cost - "+cost);
		
		int[] dcost = ShortestPath.dijkstra(g, 0);
		System.out.println("Dijkstra cost - "+dcost[7]);
		
	}

	public static int findShortestPath(Graph g) {
		int V = g.getV();
		int[][] adjMat = g.getAdjMat();
		int[] cost = new int[V], dest = new int[V];

		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[V - 1] = 0;

		for (int i = V - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int k = i + 1; k < V; k++) {
				if (adjMat[i][k] != Integer.MAX_VALUE && adjMat[i][k] + cost[k] < min) {
					min = adjMat[i][k] + cost[k];
					dest[i] = k;
				}
			}
			cost[i] = min;
		}
		
		System.out.println("Vertex\tDestination\tCost");
		for(int i=0; i<V; i++) {
			System.out.println(i+"\t"+dest[i]+"\t\t"+cost[i]);
		}
		System.out.println();
		
		printPath(dest, V);
		return cost[0];

	}

	private static void printPath(int[] dest, int V) {

		int vert = 0;
		System.out.println("The path is - ");
		while(vert<V-1){

			System.out.print(vert+"->");
			vert = dest[vert];
		
		}
		System.out.println(vert);
		
	}

}
