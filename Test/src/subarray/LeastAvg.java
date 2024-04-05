package subarray;

public class LeastAvg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array of size N, find the subarray of size K with the least average.
//
//		Problem Constraints
//		1<=k<=N<=1e5
//		-1e5<=A[i]<=1e5

//		Input 1:
//		A=[3, 7, 90, 20, 10, 50, 40]
//		B=3
//
//		Input 2:
//		A=[3, 7, 5, 20, -10, 0, 12]
//		B=2
//
//		Output 1:		3
//		Output 2:		4
//
//		Explanation 1:
//		Subarray between indexes 3 and 5
//		The subarray {20, 10, 50} has the least average 
//		among all subarrays of size 3.
//
//		Explanation 2:
//		 Subarray between [4, 5] has minimum average

		int[] A = {3, 7, 90, 20, 10, 50, 40 };
		int B = 3;
		System.out.println(solve(A, B));

	}

	
	
	public static int solve(int[] A, int B) {
		int n = A.length;
		int sum = A[0];
		int index = 0;
		for (int i = 1; i < B; i++) {
			sum += A[i];
		}
		System.out.println("sum :: " + sum);
		int s = sum;
		for (int i = 0; i < (n - B); i++) {
			s = s - A[i] + A[i + B];
			System.out.println(i + "  " + s);
			if (s < sum) {
				sum = s;
				index = i + 1;
			}
		}
		return index;
		
	}

}
