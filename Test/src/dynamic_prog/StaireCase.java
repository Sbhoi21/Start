package dynamic_prog;

public class StaireCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		You are climbing a staircase and it takes A steps to reach the top.
//		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//		Return the number of distinct ways modulo 1000000007

		System.out.println(climbStairs(55007));

	}

	private static int mod = 1000000007;

	public static int climbStairs(int A) {

		int dp[] = new int[A + 1];

		return count(A, dp);
	}

	private static int count(int A, int[] dp) {

		if (dp[A] != 0) {
			System.out.println(A);
			return dp[A];
		}
		if (A == 1 || A == 2) {
			return A;
		} else {
			dp[A] = ((count(A - 1, dp) % mod) + count(A - 2, dp) % mod) % mod;
			return dp[A];
		}
	}

}
