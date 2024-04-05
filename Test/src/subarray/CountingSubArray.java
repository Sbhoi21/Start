package subarray;

public class CountingSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array A of N non-negative numbers and a non-negative number B,
//		you need to find the number of subarrays in A with a sum less than B.
//		We may assume that there is no overflow.
//
//		Problem Constraints
//		1 <= N <= 103
//		1 <= A[i] <= 1000
//		1 <= B <= 107

//		Example Input
//		Input 1:
//		 A = [2, 5, 6]
//		 B = 10
//
//		Input 2:
//		 A = [1, 11, 2, 3, 15]
//		 B = 10
//		
//		Example Output
//		Output 1:		 4
//		Output 2:		 4
//		
//		Example Explanation
//		Explanation 1:
//		 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
//		Explanation 2:
//		 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}

		int A[] = { 693, 243, 451, 377, 212, 590, 741, 130, 809, 552, 454, 938, 187, 440, 483, 424, 697, 996, 378, 789,
				434, 44, 64, 754, 235, 410, 560, 561, 294, 923, 565, 819, 33, 396, 141, 248, 628, 481, 439, 111 };
		System.out.println(solve(A, 10000));
	}

	public static int solve(int[] A, int B) {

		int n = A.length;
		System.out.println(n);
		int[] pre = new int[n];
		pre[0] = A[0];
		int j = 0;
		int c = A[0] <= B ? 1 : 0;
		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + A[i];
			if (A[i] < B) {
				c++;
			} else {
				j = i;
			}
			if (pre[i] < B) {
				c++;
			}
			while ((j + 1) < i && (pre[i] - pre[j]) >= B) {
				j++;
			}
			if ((j + 1) < i && (pre[i] - pre[j]) < B) {
				c += (i - j - 1);
			}
			System.out.println("j" + j + "  " + i + "-" + A[i] + "      " + c + "  " + (pre[i] - pre[j]));
		}
		return c;
	}

}
