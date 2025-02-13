package lcRandom;

import java.util.HashMap;
import java.util.Map;

public class Q560_SubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1, 1, 1};
		int k = 2;
		System.out.println(new Q560_SubarraySum().subarraySum(nums, k));
		
		// complex input
		int[] nums1 = {1, 2, 3, 4, 5};
		int k1 = 10;
		System.out.println(new Q560_SubarraySum().subarraySum(nums1, k1));
		
		int[] nums2 = {10,5,7,1,2,3,4,5,6,7,8,9,10};
		int k2 = 15;
		System.out.println(new Q560_SubarraySum().subarraySum(nums2, k2));
	}
	
	public int subarraySum(int[] nums, int k) {

		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;

	}
	
	// O(n) time complexity
	public int subarraySum1(int[] nums, int k) {

		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;

	}
}
