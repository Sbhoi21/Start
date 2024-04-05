package lc98ques;

import java.util.Iterator;

public class W1H_BinarySearch {

//	Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//			You must write an algorithm with O(log n) runtime complexity.
//			Example 1:
//			Input: nums = [-1,0,3,5,9,12], target = 9
//			Output: 4
//			Explanation: 9 exists in nums and its index is 4

//			Example 2:
//			Input: nums = [-1,0,3,5,9,12], target = 2
//			Output: -1
//			Explanation: 2 does not exist in nums so return -1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { -1, 0, 3, 5, 9, 12, 14, 16, 18, 19, 22, 32, 34, 36, 39, 41, 44 };
		int target = -1;
		System.out.println(exponentialSearch(nums, target));

//		Linear Search
//		Sentinel Linear Search
//		Binary Search
//		Meta Binary Search | One-Sided Binary Search
//		Ternary Search
//		Jump Search
//		Interpolation Search
//		Exponential Search
//		Fibonacci Search
//		The Ubiquitous Binary Search

	}

	public static int linerSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}

	static int recursiveLinearsearch(int arr[], int size, int key) {
		if (size == 0) {
			return -1;
		} else if (arr[size - 1] == key) {

			// Return the index of found key.
			return size - 1;
		}
		return recursiveLinearsearch(arr, size - 1, key);
	}

//	binary search
	static int search(int nums[], int target) {
		int i = 0, t = nums.length - 1;
		while (i <= t) {
			int x = (t + i) / 2;
			if (nums[x] == target) {
				return x;
			}
			if (nums[x] > target)
				t = x - 1;
			else
				i = x + 1;

		}
		return -1;
	}

	static int ternarySearch(int[] nums, int target) {

		int i = 0, t = nums.length - 1;

		while (i <= t) {
			int x1 = i + (t - i) / 3;
			int x2 = x1 + (t - i) / 3;

			if (nums[x1] == target) {
				return x1;
			}
			if (nums[x2] == target) {
				return x2;
			}

			if (nums[x1] > target)
				t = x1 - 1;
			else if (nums[x2] < target) {
				i = x2 + 1;
			} else {
				i = x1 + 1;
				t = x2 - 1;
			}
		}
		return -1;
	}

	static int jumpSearch(int[] nums, int x) {

		int n = nums.length;
		int step = (int) Math.sqrt(n);
		int prev = 0;

		if (nums[n - 1] < x)
			return -1;

		for (int i = step; i < n && nums[i] < x; i += step) {
			prev = i;
		}

		for (int i = prev; nums[i] <= x; i++) {
			if (nums[i] == x) {
				return i;
			}
		}
		return -1;
	}

	static int exponentialSearch(int arr[], int x) {

		int n = arr.length;
		int i = 1;
		while (i < n && arr[i] < x) {
			i *= 2;
		}
		int l = i / 2;
		int r = Math.min(i, n - 1);
		while (l <= r) {
			int m = (l + r) / 2;
			if (arr[m] == x)
				return m;
			else if (arr[m] < x)
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}
}
