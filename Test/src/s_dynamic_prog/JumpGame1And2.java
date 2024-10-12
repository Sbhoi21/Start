package s_dynamic_prog;

public class JumpGame1And2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 1, 1, 4 };
		int[] nums2 = { 1, 2, 3 };
		System.out.println(canJump(nums));

		System.out.println(jump(nums));
		System.out.println(jump3(nums));
		System.out.println(jump4(nums));

//		int[] nums2 = { 2, 3, 0, 1, 4 };
//		int[] nums3 = { 3, 2, 1, 0, 4 };
//		System.out.println("num2 and 3 ");
//
//		System.out.println(canJump(nums2));
//		System.out.println(canJump(nums3));
		System.out.println(jump(nums2));
		System.out.println(jump3(nums2));
		System.out.println(jump4(nums2));
//
		int[] nums4 = { 2, 3, 1, 1, 4, 2, 1, 1, 1, 1 };
		System.out.println("num4 ");
		System.out.println(jump(nums4));
		System.out.println(jump3(nums4));
		System.out.println(jump4(nums4));
	}

	// Jump Game 1
	public static boolean canJump(int[] nums) {
		int n = nums.length;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (i > max)
				return false;
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}

	// Jump Game 2
	public static int jump(int[] nums) {
		int n = nums.length;
		int max = 0, jumps = 0, currEnd = 0;
		for (int i = 0; i < n - 1; i++) {
			max = Math.max(max, i + nums[i]);
			if (i == currEnd) {
				jumps++;
				currEnd = max;
			}
		}
		return jumps;
	}

	public static int jump3(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		for (int i = 1; i < n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= nums[i] && i + j < n; j++) {
				dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
			}
		}
		return dp[n - 1];
	}

	// by recursion
	public static int jump4(int[] nums) {
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		if (nums.length == 1)
			return 0;
		if (nums[0] >= nums.length - 1)
			return 1;
		int t = jumpFromPosition(0, nums, 0, dp) + 1;
		return Math.min(t, dp[0]);
	}

	private static int jumpFromPosition(int position, int[] nums, int jump, int[] dp) {
		if (dp[position] != Integer.MAX_VALUE)
			return dp[position];
		if (position >= nums.length - 1) {
			return 0;
		}
		for (int i = position + nums[position]; i > position; i--) {
			if (i < nums.length) {
				jump = jumpFromPosition(i, nums, jump, dp) + 1;
				dp[position] = Math.min(jump, dp[position]);
				System.out.println("position: " + position + " jump: " + jump + " dp[position]: " + dp[position]);
			}
		}
		if (dp[position] != Integer.MAX_VALUE)
			return dp[position];
		return nums.length;
	}

}
