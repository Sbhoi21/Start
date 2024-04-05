package dynamic_prog;

public class CuttingRod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
//		Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
//
//		Problem Constraints
//		1 <= N <= 1000
//		0 <= A[i] <= 106
//
//		Input Format
//		First and only argument is an integer array A of size N.
//
//		Output Format
//		Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
//
//		Input 1:
//		 A = [3, 4, 1, 6, 2]
//		Input 2:
//		 A = [1, 5, 2, 5, 6]

//		Example Output
//		Output 1:		 15
//		Output 2:		 11
//
//		Example Explanation
//		Explanation 1:
//		 Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
//
//		Explanation 2:
//		 Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
//		
//		int A[] = { 1,5,2,5,6 };
		int A[] = { 2, 7, 6, 3, 25, 13, 16, 2, 40, 41, 18, 2, 9, 6, 36, 75, 59, 42, 73 };

		System.out.println(solve(A));
	}

	public static int solve(int[] A) {
		int[][] dp = new int[A.length + 1][A.length + 1];

		return count(A, dp, A.length, A.length);
	}

	private static int count(int[] a, int[][] dp, int i, int s) {
		// TODO Auto-generated method stub
		System.out.println(i + " __ " + s);
		int p = i;
		if (s < i) {
			i = s;
		}

		if (dp[s][i] != 0) {
			System.out.println("dp :: " + p + " __ " + s + " -->  " + dp[s][i]);
			return dp[s][i];
		}
		if (s == 1) {
			System.out.println("s==1   " + a[0]);
			return a[0];
		}
		if (i == 1) {
			dp[s][i] = a[p - 1] * s;
			System.out.println("i==1 :: " + p + " __ " + s + " -->  " + dp[s][i]);
			return dp[s][i];
		}
		if (s == 0) {
			System.out.println("s==0 :: " + p + " __ " + s + " -->  " + 0);
			return 0;
		}

		int t = Math.max((a[i - 1] + count(a, dp, i, s - i)), count(a, dp, i - 1, s));
		System.out.println(p + " __ " + s + " -->  " + t);
		dp[s][i] = t;
		return t;
	}

}
