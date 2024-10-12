package test_copilot;

// LC 896. Monotonic Array
public class MonotonicArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = { 1, 2, 2, 3 };
		System.out.println(isMonotonic(A));
	}

	public static boolean isMonotonic(int[] A) {
		boolean increasing = true;
		boolean decreasing = true;
		for (int i = 1; i < A.length; i++) {
			if (A[i] < A[i - 1]) {
				increasing = false;
			}
			if (A[i] > A[i - 1]) {
				decreasing = false;
			}
		}
		return increasing || decreasing;
	}
}
