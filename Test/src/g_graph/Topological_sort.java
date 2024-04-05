package g_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Topological_sort {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		B.add(new ArrayList<Integer>(Arrays.asList(6, 3)));
		B.add(new ArrayList<Integer>(Arrays.asList(6, 1)));
		B.add(new ArrayList<Integer>(Arrays.asList(5, 3)));
		B.add(new ArrayList<Integer>(Arrays.asList(5, 2)));
		B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		B.add(new ArrayList<Integer>(Arrays.asList(4, 2)));
		System.out.println(solve(6, B));
	}

	public static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
		int[] indegree = new int[A + 1];
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
		// Initialize the graph map
		for (int i = 1; i <= A; i++) {
			graph.put(i, new ArrayList<Integer>());
		}

		// Build the graph and calculate the indegrees
		for (int i = 0; i < B.size(); i++) {
			graph.get(B.get(i).get(0)).add(B.get(i).get(1));
			indegree[B.get(i).get(1)]++;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		// Add nodes with indegree 0 to the queue
		for (int i = 1; i <= A; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			ans.add(node);

			for (int adjacent : graph.get(node)) {
				indegree[adjacent]--;
				if (indegree[adjacent] == 0) {
					queue.add(adjacent);
				}
			}
		}

		// If not all nodes are visited, it means there is a cycle
		if (ans.size() != A) {
			return new ArrayList<>();
		}

		return ans;
	}

}
