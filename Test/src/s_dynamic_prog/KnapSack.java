package s_dynamic_prog;

public class KnapSack {

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

		int A[] = { 18, 35, 1, 20, 25, 29, 9, 13, 15, 6, 46, 32, 28, 12, 42, 46, 43, 28, 37, 42, 5, 3, 4, 43, 33, 22,
				17, 19, 46, 48, 27, 22, 39, 20, 13, 18, 50, 36, 45, 4, 12, 23, 34, 24, 15, 42, 12, 4, 19, 48, 45, 13, 8,
				38, 10, 24, 42, 30, 29, 17, 36, 41, 43, 39, 7, 41, 43, 15, 49, 47, 6, 41, 30, 21, 1, 7, 2, 44, 49, 30,
				24, 35, 5, 7, 41, 17, 27, 32, 9, 45, 40, 27, 24, 38, 39, 19, 33, 30, 42, 34, 16, 40, 9, 5, 31, 28, 7,
				24, 37, 22, 46, 25, 23, 21, 30, 28, 24, 48, 13, 37, 41, 12, 37, 6, 18, 6, 25, 32, 3, 1, 1, 42, 25, 17,
				31, 8, 42, 8, 38, 8, 38 };

		int B[] = { 3652, 5620, 2574, 3471, 3957, 4692, 4855, 3740, 991, 5446, 5089, 2066, 4314, 1740, 2476, 1798, 4994,
				3206, 5406, 4370, 3471, 3350, 5458, 6175, 4982, 4908, 3504, 4251, 3804, 893, 5139, 3420, 3263, 2234,
				2851, 1815, 5971, 1644, 3276, 1454, 2193, 1766, 4670, 1177, 2712, 1593, 5798, 3759, 4293, 5488, 5232,
				4670, 2768, 5252, 1561, 5195, 3396, 206, 5801, 5381, 4786, 3923, 2488, 4077, 1170, 3607, 2707, 4420,
				5189, 1150, 2848, 4085, 1618, 1004, 5853, 1801, 4675, 2103, 4535, 5587, 3603, 4176, 4239, 5384, 3981,
				1067, 5498, 4585, 5126, 5766, 2509, 3762, 3696, 3845, 5401, 4180, 1494, 1705, 4219, 3584, 252, 1672,
				4467, 5470, 5473, 1460, 1743, 1637, 1292, 2491, 1367, 1531, 4693, 5524, 1604, 2675, 3483, 5577, 1390,
				5271, 2833, 931, 3553, 3622, 2825, 3333, 4988, 3127, 451, 3774, 5249, 1886, 3543, 2042, 3272, 2971,
				3624, 4364, 3204, 5095, 4711 };
		int c = 809580;
//		int[] A = { 60, 100, 120, 200, 400, 500 };
//		int[] B = { 10, 20, 30, 40, 20, 50 };
//		int[] A = { 60, 100, 120};
//		int[] B = { 10, 20, 30 };
//		int c = 50;
		System.out.println(solve(A, B, c));
	}

	public static int solve(int[] A, int[] B, int C) {
		int max = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			max += A[i];
		}
		int dp[][] = new int[A.length][max + 1];
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
			s = A[i] + sack(A, B, i - 1, w - B[i], dp);
			if (s > a) {
				a = s;
			}
		}
		dp[i][w] = a;
		return a;
	}

}
