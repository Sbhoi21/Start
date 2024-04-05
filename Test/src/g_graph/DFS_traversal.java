package g_graph;

import java.util.*;

public class DFS_traversal {

	private int V; // Number of vertices
	private LinkedList<Integer>[] adjList; // Adjacency list representation

	// Constructor
	DFS_traversal(int v) {
		V = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	// Add an edge to the graph
	void addEdge(int v, int w) {
		adjList[v].add(w);
	}

	// Depth-First Search from a given vertex
	void DFS(int v) {
		boolean[] visited = new boolean[V];
		DFSUtil(v, visited);
	}

	// Recursive utility function for DFS
	private void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		for (int neighbor : adjList[v]) {
			if (!visited[neighbor]) {
				DFSUtil(neighbor, visited);
			}
		}
	}

	public static void main(String[] args) {
		// Create a sample graph
		int V = 5;
		DFS_traversal graph = new DFS_traversal(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);

		System.out.println("Depth-First Traversal (starting from vertex 0):");
		graph.DFS(0);
	}
}
