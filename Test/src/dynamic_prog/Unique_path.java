package dynamic_prog;

import java.util.ArrayList;
import java.util.Arrays;

public class Unique_path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		new int[20][30];
		int A[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, };

		System.out.println(uniquePathsWithObstacles(A));

	}

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n][m];

		// Base case: if the starting position is an obstacle, no paths are possible
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		// Initialize the first cell with 1, as there is only one way to reach it
		dp[0][0] = 1;

		// Calculate the number of unique paths for the first row
		for (int j = 1; j < m; j++) {
			if (obstacleGrid[0][j] == 0) {
				dp[0][j] = dp[0][j - 1];
			}
		}

		// Calculate the number of unique paths for the first column
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[i][0] == 0) {
				dp[i][0] = dp[i - 1][0];
			}
		}

		// Calculate the number of unique paths for the remaining cells
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[n - 1][m - 1];
	}

	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
		int n = A.size(), m = A.get(0).size();
		if (A.get(0).get(0) == 1 || A.get(n - 1).get(m - 1) == 1)
			return 0;
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], -1);
		return path(n - 1, m - 1, A, dp);
	}

	private int path(int n, int m, ArrayList<ArrayList<Integer>> A, int[][] dp) {
		if (n == 0 && m == 0)
			return 1;
		if (n < 0 || m < 0 || A.get(n).get(m) == 1)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];
		return dp[n][m] = path(n - 1, m, A, dp) + path(n, m - 1, A, dp);
	}

}
