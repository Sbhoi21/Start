package dynamic_prog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SquareSum {

	static Map<Integer, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//		for 12, = 1s * (12)				--> 12
//				= 2s + 2s + 2s			--> 3
//				= 3s + 1s + 1s + 1s		--> 4
//		so, min is 3

		System.out.println(countMinSquares(15));

	}

//	1400ms
	public static int countMinSquares(int A) {
		if (A == 1 || A == 0) {
			return A;
		} else if (memo.containsKey(A)) {
			return memo.get(A);
		} else {
			int n = (int) Math.sqrt(A);
			if (n * n == A) {
				memo.put(A, 1);
				return 1;
			}
			int minSum = A;
			for (int i = n; i > n / 2; i--) {
				int remaining = A - (i * i);
				int t;
				if (memo.containsKey(remaining)) {
					t = memo.get(remaining);
				} else {
					t = 1 + countMinSquares(remaining);
					memo.put(remaining, t);
				}
				if (t < minSum) {
					minSum = t;
				}
			}
			memo.put(A, minSum);
			return minSum;
		}
	}

//	another solution 505ms
	public int countMinSquares1(int A) {
		// Create an array to store the minimum count of numbers required for each sum
		int[] dp = new int[A + 1];
		// Initialize the dp array with maximum values, indicating that the values have
		// not been calculated yet
		Arrays.fill(dp, Integer.MAX_VALUE);
		return minSqu(A, dp);
	}

	public int minSqu(int i, int[] dp) {
		// Base case : If the current sum is less than or equal to 0, we return 0.
		if (i <= 0) {
			return 0;
		}
		// If the value for the current sum has not been calculated yet, compute it.
		if (dp[i] == Integer.MAX_VALUE) {
			// Iterate through all possible perfect squares but only taking higher factors,
			// as lower factors can be neglected.
			// Here, j * j represents the perfect square.
			int n = (int) Math.sqrt(i);
			for (int j = n; j > (n / 2); j--) {
				// Recursively call minSqu for the remaining sum after subtracting j * j,
				// and add 1 to account for the current perfect square.
				dp[i] = Math.min(dp[i], minSqu(i - j * j, dp) + 1);
			}
		}
		return dp[i];
	}

}
