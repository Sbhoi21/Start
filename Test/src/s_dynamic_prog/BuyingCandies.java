package s_dynamic_prog;

import java.util.ArrayList;
import java.util.Arrays;

public class BuyingCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
//
//		The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
//
//		Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?

//		input 1:
//
//			 A = [1, 2, 3]
//			 B = [2, 2, 10]
//			 C = [2, 3, 9]
//			 D = 8
//			Input 2:
//
//			 A = [2]
//			 B = [5]
//			 C = [10]
//			 D = 99
//
//		Output 1:
//			 10
//		Output 2:
//			 90

//		Explanation 1:
//			 Choose 1 Packet of kind 1 = 1 Candy of 2 Sweetness = 2 Sweetness
//			 Choose 2 Packet of kind 2 = 2 Candy of 2 Sweetness = 8 Sweetness
//	 
//		Explanation 2:
//			 Buy 9 Packet of kind 1. 18 Candy each of 5 Sweetness = 90 Sweetness

//		int[] A = { 1, 2, 3 };
//		int[] B = { 2, 2, 10 };
//		int[] C = { 2, 3, 9 };
//		int D = 8;
//		int[] A = { 2 };
//		int[] B = { 5 };
//		int[] C = { 10 };
//		int D = 99;
//		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4));
//		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(4, 5));
//		ArrayList<Integer> C = new ArrayList<>(Arrays.asList(6, 13));

		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 2, 10));
		ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 3, 9));

		int D = 8;

		System.out.println(solve(A, B, C, D));

	}

	public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {

		int dp[][] = new int[A.size()][D + 1];
		for (int i = 0; i < A.size(); i++)
			Arrays.fill(dp[i], -1);

		int[] dp1 = new int[D + 1];
		Arrays.fill(dp1, -1);

		return minimum_cost(0, D, A, B, C, dp1);
	}

	private static int minimum_cost(int index, int D, ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C,
			int dp[][]) {

		if (index == A.size() || D == 0)
			return 0;

		int ans = Integer.MIN_VALUE, cost = C.get(index), sweetness = B.get(index) * A.get(index);

		if (dp[index][D] != -1) {
			System.out.println(index + " ++ " + D + " __  " + dp[index][D]);
			return dp[index][D];
		}
		ans = minimum_cost(index + 1, D, A, B, C, dp);
		if (D - cost >= 0) {
			ans = Math.max(ans, minimum_cost(index, D - cost, A, B, C, dp) + sweetness);
		}

		return dp[index][D] = ans;
	}

	private static int minimum_cost(int index, int D, ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C,
			int dp[]) {
		

		if (index == A.size() || D == 0)
			return 0;

		int ans = Integer.MIN_VALUE, cost = C.get(index), sweetness = B.get(index) * A.get(index);

		if (dp[D] != -1) {
			System.out.println(index + " ++ " + D + " __  " + dp[D]);
			return dp[D];
		}
		System.out.println(index + " ++ " + D + " __  ");
		ans = minimum_cost(index + 1, D, A, B, C, dp);
		System.out.println(index + " ++ " + D + " --------->   " + ans);

		if (D - cost >= 0) {
			ans = Math.max(ans, minimum_cost(0, D - cost, A, B, C, dp) + sweetness);
		}

		return dp[D] = ans;
	}

//	greedy trial, first try...

//	public static int solve(int[] A, int[] B, int[] C, int D) {
//
//		int n = A.length;
//		double[] dp = new double[n];
//
//		for (int i = 0; i < n; i++) {
//			dp[i] = (A[i] * B[i]) / (double) C[i];
//		}
//		int i = 0, max = 0;
//		double[] temp = dp;
//		for (int j = 1; j < dp.length; j++) {
//			if (dp[j] > dp[i]) {
//				i = j;
//			}
//		}
//
//		while (dp[i] != 0) {
//
//			max = Math.max(max, count(A, B, C, dp, i, D));
//			dp = temp;
//			dp[i] = 0;
//			for (int j = 1; j < dp.length; j++) {
//				if (dp[j] > dp[i]) {
//					i = j;
//				}
//			}
//
//		}
//		return max;
//	}
//
//	private static int count(int[] a, int[] b, int[] c, double[] dp, int i, int d) {
//		// TODO Auto-generated method stub
//		int s = 0;
//		if (d <= 0) {
//			return 0;
//		}
//		if (d < c[i]) {
//			dp[i] = 0;
//			i = 0;
//			for (int j = 1; j < dp.length; j++) {
//				if (dp[j] > dp[i]) {
//					i = j;
//				}
//			}
//			if (dp[i] == 0) {
//				return 0;
//			}
//			s = count(a, b, c, dp, i, d);
//
//		} else {
//			s = (a[i] * b[i]) + count(a, b, c, dp, i, d - c[i]);
//		}
//		return s;
//	}

}
