package e_tree;

import java.io.*;
import java.util.*;

public class CutTree2 {

	/*
	 * Complete the cuttree function below.
	 */

	static long ans = 1;

	static int[] eo;
	static int[][] ej;

	static long[][] dp;
	static long[] tt;
	static int k;

	static long cutTree(int n, int m, int[][] edges) {
		/*
		 * Write your code here.
		 */

		if (n == 1) {
			return 2;
		}
		k = m;
		if (k == n)
			k = n - 1;
		init(n);
		for (int h = 0; h < n - 1; h++) {
			int i = edges[h][0] - 1;
			int j = edges[h][1] - 1;
			append(i, j);
			append(j, i);
		}

		System.out.println("ej: " + ej.length);
		for (int[] e : ej) {
			for (int e1 : e) {
				System.out.print(e1 + "   ");
			}
			System.out.println("   ");
		}

		dfs(-1, 0);
		return ans;
	}

	static void append(int i, int j) {
		int o = eo[i]++;
		System.out.println("o: " + o + " eo[" + i + "]=" + eo[i] + "  i=" + i + "  j=" + j);
		if (o >= 2 && (o & o - 1) == 0) {
			System.out.println("o << 1 :   " + (o << 1));
			ej[i] = Arrays.copyOf(ej[i], o << 1);
			System.out.println("ej[" + i + "]=" + ej[i] + "  i=" + i + "  j=" + j);
		}
		ej[i][o] = j;

		System.out.println("ej[" + i + "][" + o + "]=" + ej[i][o] + "  i=" + i + "  j=" + j);

	}

	static void init(int n) {
		eo = new int[n];
		ej = new int[n][2];
		dp = new long[n][k + 1];
		tt = new long[k + 1];
	}

	static void mult(long[] aa, long[] bb) {
		Arrays.fill(tt, 0);
		for (int i = 0; i <= k; i++)
			for (int j = 0; i + j <= k; j++)
				tt[i + j] += aa[i] * bb[j];
		System.arraycopy(tt, 0, aa, 0, k + 1);
	}

	static void dfs(int p, int i) {
		dp[i][0] = 1;
		for (int o = eo[i]; o-- > 0;) {
			int j = ej[i][o];
			if (j != p) {
				dfs(i, j);
				dp[j][1]++;
				mult(dp[i], dp[j]);
			}
		}
		for (int h = p == -1 ? k : k - 1; h >= 0; h--) {
			ans += dp[i][h];
		}
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0].trim());

		int k = Integer.parseInt(nk[1].trim());

		int[][] edges = new int[n - 1][2];

		for (int edgesRowItr = 0; edgesRowItr < n - 1; edgesRowItr++) {
			String[] edgesRowItems = scanner.nextLine().split(" ");

			for (int edgesColumnItr = 0; edgesColumnItr < 2; edgesColumnItr++) {
				int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
				edges[edgesRowItr][edgesColumnItr] = edgesItem;
			}
		}

		long result = cutTree(n, k, edges);
		System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
	}
}