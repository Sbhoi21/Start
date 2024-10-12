package test_copilot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	// LC. 15 3Sum
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-1, 0, 1, 2, -1, -4};
		System.out.println(threeSum(nums));
		
	}
	
	// time complexity is O(n^2) and space complexity is O(1)
	public static List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		}
			
		Set<List<Integer>> result = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
			
		return new ArrayList<>(result);
		
		
	}
	
}
