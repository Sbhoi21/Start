package s_dynamic_prog;

import java.util.Arrays;

public class LongestPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Q1. Longest Palindromic Subsequence
//		Unsolved
//		feature icon
//		Using hints is now penalty free
//		Use Hint
//		Problem Description
//		Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
//		You need to return the length of longest palindromic subsequence.
//
//		Problem Constraints
//		1 <= length of(A) <= 103
//
//		Input Format
//		First and only integer is a string A.
//
//		Output Format
//		Return an integer denoting the length of longest palindromic subsequence.
//
//		Input 1: A = "bebeeed"
//		Input 2: A = "aedsead"
//
//		Output 1:	4
//		Output 2:	5
//
//		Explanation 1:
//		 		The longest palindromic subsequence is "eeee", which has a length of 4.
//		Explanation 2:
//		 		The longest palindromic subsequence is "aedea", which has a length of 5.

		String s = "bebeeb";
		System.out.println(solve(s));
	}

	public static int solve(String A) {
		int n = A.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		return count(A, 0, n - 1, dp);
	}

	private static int count(String a, int i, int n, int[][] dp) {
		// TODO Auto-generated method stub

		if (dp[i][n] != -1) {
			return dp[i][n];
		}
		if (i == n) {
			return dp[i][n] = 1;
		}
		if (i > n) {
			return dp[i][n] = 0;
		}

		if (a.charAt(i) == a.charAt(n)) {
			dp[i][n] = (2 + count(a, i + 1, n - 1, dp));
		} else {
			dp[i][n] = (Math.max(count(a, i + 1, n, dp), count(a, i, n - 1, dp)));
		}
		return dp[i][n];
	}
}
