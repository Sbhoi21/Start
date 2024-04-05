package basic;

public class Two_Sum {

	final static int mod = 1000000007;

	public static int solve(int A, int B) {
		int[][] dp = new int[A + 1][B + 1];
		int i;
		dp[1][0] = 0;
		int s = Math.min(9, B);
		for (i = 1; i <= s; i++) {
			dp[1][i] = 1;
		}
		for (i = 10; i <= B; i++) {
			dp[1][i] = 0;
		}
		return count(A, B, dp) % mod;
	}

	static int count(int A, int B, int[][] dp) {
		if (dp[A][B] != -1)
			return dp[A][B];
//		if (A == 1 && B > 9) { 
//			dp[A][B] = 0;
//			return 0;
//		}

		int ans = 0;

		for (int i = 0; i <= 9; i++) {
			if (i < B)
				ans = (ans + count(A - 1, B - i, dp) % mod) % mod;
		}
		dp[A][B] = ans;
		return dp[A][B];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solve(2, 3));
	}

//	static int[][] dp;

//	public static int solve(int A, int B) {
//		dp = new int[A + 1][B + 1];
//		if (A == 1 && B > 9) {
//			dp[A][B] = 0;
//			return 0;
//		}
//		if (A == 1 || B == 0) {
//			dp[A][B] = 1;
//			return 1;
//		}
//		int end = Math.min(9, B);
//		long sum = 0;
//		for (int i = end; i > 0; i--) {
//			long c = count(A - 1, B - i);
//			if (c == 0)
//				break;
//			sum = (sum + c % mod) % mod;
//		}
//
//		return (int) sum;
//	}
//
//	private static long count(int A, int B) {
//
//		if (dp[A][B] != 0) {
//			return dp[A][B];
//		}
//		if (A == 1 && B > 9) {
//			dp[A][B] = 0;
//			return 0;
//		}
//		if (A == 1 || B == 0) {
//			dp[A][B] = 1;
//			return 1;
//		}
//		long sum = 0;
//		int end = Math.min(9, B);
//
//		for (int i = end; i > -1; i--) {
//			long c = count(A - 1, B - i);
//			if (c == 0)
//				break;
//			sum = (sum + c % mod) % mod;
//		}
//
//		dp[A][B] = (int) sum;
//		System.out.println(A + " , " + B + " = " + sum);
//		return sum;
//	}
}
