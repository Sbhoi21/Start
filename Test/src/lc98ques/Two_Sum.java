package lc98ques;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] twoSum1(int[] nums, int target) {

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] == target - nums[j]) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0 };
	}

	public static int[] twoSum(int[] nums, int target) {

		int n = nums.length;
		Map<Integer, Integer> s = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int c = target - nums[i];
			if (s.containsKey(c)) {
				return new int[] { s.get(c), i };
			}
			s.put(c, i);
		}
		return new int[] { 0 };
	}
}
