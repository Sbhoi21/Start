package lc98ques;

import java.util.Arrays;

public class W1H_BinaryRecursiveSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 3, 5, 9, 12, 14, 16, 18, 19, 22, 32, 34, 36, 39, 41, 44 };
		int target = -1;
		System.out.println(exponentialSearch(nums, nums.length, target));
	}

	public static int interpolationSearch(int arr[], int lo, int hi, int x) {
		int pos;

// Since array is sorted, an element present in array must be in range defined by corner
		if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

// Probing the position with keeping
// uniform distribution in mind.
			pos = lo + (((hi - lo) / (arr[hi] - arr[lo])) * (x - arr[lo]));

// Condition of target found
			if (arr[pos] == x)
				return pos;

// If x is larger, x is in right sub array
			if (arr[pos] < x)
				return interpolationSearch(arr, pos + 1, hi, x);

// If x is smaller, x is in left sub array
			if (arr[pos] > x)
				return interpolationSearch(arr, lo, pos - 1, x);
		}
		return -1;
	}

	static int exponentialSearch(int arr[], int n, int x) {

		if (arr[n - 1] == x)
			return n - 1;

		// Find range for binary search by
		// repeated doubling
		int i = 1;
		while (i < n && arr[i] <= x)
			i = i * 2;

		// Call binary search for the found range.
		return Arrays.binarySearch(arr, i / 2, Math.min(i, n - 1), x);
	}

}
