package dynamic_prog;

import java.util.Arrays;

public class BirthdayParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
//
//		NOTE:
//		Each dish is supposed to be eaten by only one person. Sharing is not allowed.
//		Each friend can take any dish unlimited number of times.
//		There always exists a dish with filling capacity 1 so that a solution always exists.

//		Input Format
//		First Argument is vector A, denoting eating capacities
//		Second Argument is vector B, denoting filling capacities
//		Third Argument is vector C, denoting cost
//
//		Output Format
//		Return a single integer, the answer to the problem
//
//		Input 1:
//		A = [2, 4, 6]
//		B = [2, 1, 3]
//		C = [2, 5, 3]
//
//		Input 2:
//		A = [2]
//		B = [1]
//		C = [2]
//				
//		Example Output
//		Output 1:		12
//		Output 2:		4

//		Explanation 1:
//			First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
//			So 2 + 2*2 + 3*2 = 12.
//		Explanation 2:
//			Only way is to take 2 dishes of cost 2, hence 4.

//		int[] A = { 2, 3, 1, 5, 4 };
//		int[] B = { 3, 2, 4, 1, 1 };
//		int[] C = { 1, 2, 5, 10, 5 };
//		int[] A = { 2, 4, 6 };
//		int[] B = { 2, 1, 3 };
//		int[] C = { 2, 5, 3 };
		int[] A = { 2, 3, 1, 5, 4 };
		int[] B = { 3, 2, 4, 1 };
		int[] C = { 1, 2, 5, 10 };

		System.out.println(solve(A, B, C));

	}

	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int solve(final int[] A, final int[] B, final int[] C) {
		int maxCapacity = 0;
		for (int capacity : A) {
			maxCapacity = Math.max(maxCapacity, capacity);
		}
		int[] dp = new int[maxCapacity + 1];
		// Initialize the DP table with a large value
		Arrays.fill(dp, Integer.MAX_VALUE);
		// Base case Minimum cost for capacity 0 is 0
		dp[0] = 0;
		// Iterate over each dish
		for (int i = 0; i < B.length; i++) {
			int dishFilling = B[i];
			int dishCost = C[i];
			// Iterate over each capacity from dishFilling to maxCapacity
			for (int capacity = dishFilling; capacity <= maxCapacity; capacity++) {
				if (dp[capacity - dishFilling] != Integer.MAX_VALUE) {
					dp[capacity] = Math.min(dp[capacity], dp[capacity - dishFilling] + dishCost);
				}
			}
		}
		int minCost = 0;
		// Calculate the minimum cost for each friend's eating capacity
		for (int capacity : A) {
			minCost += dp[capacity];
		}
		return minCost;
	}

	public static int solve1(final int[] A, final int[] B, final int[] C) {

//		int n = C.length;
//		int[][] dp = new int[n][];
//
//		for (int i = 0; i < n; i++) {
//			dp[i] = new int[C[i]];
//			Arrays.fill(dp[i], -1);
//		}
		int n = Arrays.stream(A).max().getAsInt();
		int[] dp = new int[n + 1];
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += count(0, A[i], B, C, dp);
		}

		return sum;
	}

	private static int count(int i, int a, int[] B, int[] C, int[] dp) {
		// TODO Auto-generated method stub
		System.out.println("------------> " + i + " _ " + a + " _ ");

		if (dp[a] != 0) {
			System.out.println("dp --> " + i + " _ " + a + " ______ " + dp[a]);
			return dp[a];
		}
		if (a == 0) {
			return 0;
		}
		if (a < 0 || i == C.length) {
			return Integer.MAX_VALUE;
		}
		int t = count(i + 1, a, B, C, dp);
		int r = a - B[i];
		if (r >= 0) {
			t = Math.min(t, (C[i] + count(0, r, B, C, dp)));
		}
		System.out.println(i + " _ " + a + " _ " + t);
		dp[a] = t;
		return t;
	}

}
