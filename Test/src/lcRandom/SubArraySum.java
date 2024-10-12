package lcRandom;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 0, 2, 1, 1 };
		int k = 4;
		System.out.println(subarraySum(nums, k));
//
//		int[] nums1 = { 1, 2, 3 };
//		int k1 = 3;
//		System.out.println(subarraySum(nums1, k1));
//
//		// big complex input
//		int[] nums2 = { 28, 54, 7, -70, 22, 65, -6 };
//		int k2 = 100;
//		System.out.println(subarraySum(nums2, k2));
//
//		// long array
//		int[] nums3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		int k3 = 15;
//		System.out.println(subarraySum(nums3, k3));

	}

	public static int subarraySum4(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}

//	public static int subarraySum(int[] nums, int k) {
//		int count = 0;
//		int sum = 0;
//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(0, 1);
//		for (int i = 0; i < nums.length; i++) {
//			sum += nums[i];
//			if (map.containsKey(sum - k)) {
//				count += map.get(sum - k);
//			}
//			map.put(sum, map.getOrDefault(sum, 0) + 1);
//		}
//		return count;
//	}

	// optimized
	public static int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int n : nums) {
			sum += n;
			count += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			System.out.print("map: ");
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				System.out.print("[" + entry.getKey() + " " + entry.getValue() + " ]");
			}
			System.out.println("");
		}
		return count;
	}

	// optimized
	public static int subarraySum3(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			count += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	// sliding window
	public static int subarraySum2(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum > k) {
				sum -= nums[start];
				start++;
			}
			if (sum == k) {
				count++;
			}
		}
		return count;
	}

	// most optimized solution using hashtable
	private static final int NULL = Integer.MIN_VALUE, MIXER = 0x9E3779BA;

	public int subarraySum1(int[] nums, int k) {
		final int mask = mask(nums.length);
		final int[] hashtable = new int[mask + 1];
		int res = 0, sum = 0, zeros = 1;
		for (final int n : nums) {
			sum += n;
			final int diff = sum - k;

			if (diff != 0) {
				int i = diff * MIXER & mask;
				while (true) {
					final int key = hashtable[i];
					if (key == 0)
						break;
					if (key == diff) {
						res += hashtable[i + 1];
						break;
					}
					i = i + 2 & mask;
				}
			} else {
				res += zeros;
			}

			if (sum != 0) {
				int i = sum * MIXER & mask;
				while (true) {
					final int key = hashtable[i];
					if (key == 0) {
						hashtable[i] = sum;
						hashtable[i + 1] = 1;
						break;
					}
					if (key == sum) {
						hashtable[i + 1]++;
						break;
					}
					i = i + 2 & mask;
				}
			} else {
				zeros++;
			}
		}
		return res;
	}

	private static int mask(int n) {
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		return (n << 1) | 31;
	}

}
