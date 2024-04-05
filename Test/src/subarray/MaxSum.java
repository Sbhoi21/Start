package subarray;

public class MaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
//		But the sum must not exceed B.
//
//		Problem Constraints
//		1 <= A <= 103
//		1 <= B <= 109
//		1 <= C[i] <= 106

//		Input 1:
//		A = 5
//		B = 12
//		C = [2, 1, 3, 4, 5]
//
//		Input 2:
//		A = 3
//		B = 1
//		C = [2, 2, 2]
//		
//		Output 1:   12
//		Output 2:	0

//		Explanation 1:
//		We can select {3,4,5} which sums up to 12 which is the maximum possible sum.
//		Explanation 2:
//		All elements are greater than B, which means we cannot select any subarray.
//		Hence, the answer is 0.

		int[] c = { 64, 13, 93, 19, 42, 40, 41, 66, 89, 75, 69, 78, 54, 64, 42, 51, 95, 53, 39, 63, 30, 24, 10, 66, 13,
				64, 81, 15, 44, 6, 60, 86, 59, 73, 47, 53, 86, 5, 49, 58, 12, 35, 45, 76, 6, 52, 26, 6, 85, 39, 86, 73,
				67, 81, 84, 81, 24, 36, 42, 76, 98, 92, 70, 35, 66, 67, 5, 46, 2, 91, 27, 50, 42, 77, 18, 77, 60, 45,
				76, 26, 33, 25, 40, 32, 98 };

//		System.out.println(maxSubarray(85, 4176, c));

		System.out.println(maxSubarray(1, 7, new int[] { 4 }));

	}

	public static int maxSubarray(int A, int B, int[] C) {

		// Creating pSum

		int ans = 0;
		for (int i = 0; i < A; i++) { // Finding Staring point.
			int sum = 0;
			for (int j = i; j < A; j++) {
				sum = sum + C[j];
				if (sum > ans & sum <= B)
					ans = sum;
			}
		}
		return ans;
	}

}
