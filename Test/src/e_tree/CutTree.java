package e_tree;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class CutTree {

	/*
	 * Complete the cuttree function below.
	 */
	static List<List<Integer>> adj;
	static int[][] dp;

	static int cuttree(int n, int k, int[][] edges) {
		adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		// Build adjacency list
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		dp = new int[n + 1][k + 1];
		dfs(1, -1, k);

		int totalSubtrees = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				totalSubtrees += dp[i][j];
			}
		}

		return totalSubtrees;
	}

	static void dfs(int node, int parent, int k) {
		dp[node][0] = 1;
		for (int child : adj.get(node)) {
			if (child != parent) {
				dfs(child, node, k);
				for (int i = k; i >= 0; i--) {
					for (int j = 1; j <= i; j++) {
						dp[node][i] += dp[child][j - 1] * dp[node][i - j];
						System.out.println("dp[" + node + "][" + i + "] = " + dp[node][i] + "  node=" + node + " i=" + i
								+ " j=" + j);
					}
				}
			}
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");
		int n = Integer.parseInt(nk[0].trim());
		int k = Integer.parseInt(nk[1].trim());
//		int n = 3;
//
//		int k = 1;

		int[][] edges = new int[n - 1][2];

		for (int edgesRowItr = 0; edgesRowItr < n - 1; edgesRowItr++) {
			String[] edgesRowItems = scanner.nextLine().split(" ");

			for (int edgesColumnItr = 0; edgesColumnItr < 2; edgesColumnItr++) {
				int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
				edges[edgesRowItr][edgesColumnItr] = edgesItem;
			}
		}
//		for (int i = 0; i < n - 1; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.println(edges[i][j]);
//			}
//		}
		int result = cuttree(n, k, edges);

		System.out.println(result);
	}
}
