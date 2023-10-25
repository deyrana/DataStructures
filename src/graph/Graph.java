package graph;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

	// Number of vertices in graph
	private int V;

	// Array of linked list => Adjacency list
	private LinkedList<Integer> adj[];

	private Integer[][] adjMat;

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		super();
		V = v;

		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();

		adjMat = new Integer[v][v];
	}

	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public LinkedList<Integer>[] getAdj() {
		return adj;
	}

	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}

	public Integer[][] getAdjMat() {
		return adjMat;
	}

	public void setAdjMat(Integer[][] adjMat) {
		this.adjMat = adjMat;
	}

	// Function to add a directed edge from v to w
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adjMat[v][w] = 1;
	}

	@Override
	public String toString() {
		return "Graph [V=" + V + ", adj=" + Arrays.toString(adj) + "]";
	}

}
