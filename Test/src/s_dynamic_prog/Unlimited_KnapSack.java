package s_dynamic_prog;

public class Unlimited_KnapSack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//
//		Also given an integer C which represents knapsack capacity.
//
//		Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

//		Input 1:
//				 A = [60, 100, 120]
//				 B = [10, 20, 30]
//				 C = 50
//		Input 2:
//				 A = [10, 20, 30, 40]
//				 B = [12, 13, 15, 19]
//				 C = 10
//				 
//				Example Output
//				Output 1: 	220
//				Output 2: 	0

		int[] A = { 60, 100, 120, 200, 400, 500 };
		int[] B = { 10, 20, 30, 40, 20, 50 };
//		int[] A = { 10, 20, 30, 40 };
//		int[] B = { 12, 13, 15, 19 };
		int c = 50;
		System.out.println(solve(A, B, c));
	}

	public static int solve(int[] A, int[] B, int C) {
		int dp[][] = new int[A.length][C + 1];
		return sack(A, B, A.length - 1, C, dp);
	}

	private static int sack(int[] A, int[] B, int i, int w, int[][] dp) {
		// TODO Auto-generated method stub
		if (i > -1 && dp[i][w] != 0) {
			return dp[i][w];
		}
		if (w <= 0 || i < 0) {
			return 0;
		}
		int a = sack(A, B, i - 1, w, dp);
		int s = 0;
		if (w - B[i] >= 0) {
			s = A[i] + sack(A, B, i, w - B[i], dp);
			if (s > a) {
				a = s;
			}
		}
		dp[i][w] = a;
		return a;
	}

}
