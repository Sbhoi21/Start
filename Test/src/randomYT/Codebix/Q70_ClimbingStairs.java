package randomYT.Codebix;

public class Q70_ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// n=2
		int n = 2;
		System.out.println(new Q70_ClimbingStairs().climbStairs(n));
		
		// n=3
		n = 3;
		System.out.println(new Q70_ClimbingStairs().climbStairs(n));
		
	}

	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
}
