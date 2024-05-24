package s_dynamic_prog;

import java.util.Arrays;

public class Flip_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
//
//		Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.

//		Input 1:
//			 A = [15, 10, 6]
//		Input 2:
//			 A = [14, 10, 4]
//
//		Example Output: 
//			Output 1:
//			 1
//
//			Output 2:
//			 1

		int[] A = { 14, 1, 10, 7 };
		System.out.println(solve(A));
	}

	public static int solve(final int[] A) {

		int n = A.length;
		int sum = Arrays.stream(A).sum();
		sum = sum / 2;
		int[][] dp = new int[n + 1][sum + 1];
		for (int j = 1; j <= sum; j++) {
			dp[0][j] = 9999999;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= A[i - 1]) {
					int s = 1 + dp[i - 1][j - A[i - 1]];
					if (s < dp[i][j]) {
						dp[i][j] = s;
					}
				}
			}
		}

		while (dp[n][sum] == 9999999) {
			sum--;
		}
		return dp[n][sum];
	}

}
