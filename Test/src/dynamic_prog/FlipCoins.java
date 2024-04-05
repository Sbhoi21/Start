package dynamic_prog;

import java.util.Arrays;

public class FlipCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Problem Description
//		Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
//
//		Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

//		Problem Constraints
//		1 <= length of(A) <= 100
//		Sum of all the elements will not exceed 10,000.

//		Input Format
//		First and only argument is an integer array A.
//
//		Output Format
//		Return an integer denoting the minimum number of elements whose sign needs to be flipped.

//		Input 1:
//		 A = [15, 10, 6]
//		Input 2:
//		 A = [7,7, 10, 4]

//		Output 1:		 1
//		Output 2:		 1

//		Explanation 1:
//		 Here, we will flip the sign of 15 and the resultant sum will be 1.
//		Explanation 2:
//		 Here, we will flip the sign of 14 and the resultant sum will be 0.
//		 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.

		int[] A = { 10, 10, 18 };
		System.out.println(solve(A));
	}

	public static int solve(final int[] A) {
		int sum = 0, n = A.length;
		for (int num : A)
			sum += num;
		sum = sum / 2;
		int dp[][] = new int[n + 1][sum + 1];
		int t = 0;
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int j = sum; j >= 0; j--) {
			t = count(A, n - 1, dp, j);
			if (t < n) {
				return t;
			}
		}
		return 0;
	}

	private static int count(int[] a, int i, int[][] dp, int w) {
		// TODO Auto-generated method stub
		int t = Integer.MAX_VALUE;
		if (w == 0) {
			return 0;
		}
		if (i < 0) {
			return t - 1;
		}
		if (dp[i][w] != -1) {
			System.out.println(i + " __ " + w + "--> " + dp[i][w]);
			return dp[i][w];
		}
		if (w - a[i] >= 0) {
			t = 1 + count(a, i - 1, dp, w - a[i]);
		}
		t = Math.min(count(a, i - 1, dp, w), t);
		dp[i][w] = t;
		return t;

	}

}
