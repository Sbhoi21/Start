package lc98ques;

public class W1J_MaximumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an integer array nums, find the  
//		subarray with the largest sum, and return its sum.

//		Example 1:
//		Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//		Output: 6
//		Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//
//		Example 2:
//		Input: nums = [1]
//		Output: 1
//		Explanation: The subarray [1] has the largest sum 1.
//
//		Example 3:
//		Input: nums = [5,4,-1,7,8]
//		Output: 23
//		Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

		int[] nums = { -1, -2, -1, -5 };
		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {

		int max = nums[0];
		int sum = max;
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			if (sum < 0) {
				sum = 0;
			}
			sum += nums[i];

			if (max < sum) {
				max = sum;
			}
		}
//		System.gc(); 	increases TC, but reduces SC
		return max;
	}
}
