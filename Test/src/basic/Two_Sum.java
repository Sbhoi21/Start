package basic;

public class Two_Sum {

	public static void main(String[] args) {

		int[] nums = { 3, 2, 4 };
		int target = 6;
		Two_Sum ts = new Two_Sum();
		int[] result = ts.twoSum(nums, target);
		System.out.println(result[0] + " " + result[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSum1(int[] nums, int target) {
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[j] + nums[j - i] == target) {
					return new int[] { j, j - i };
				}
			}
		}
		return null;

	}
}
