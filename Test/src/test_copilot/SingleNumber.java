package test_copilot;

public class SingleNumber {

	// Lc. 136 Single Number
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 3, 2, 1, 1, 2 };
		System.out.println(singleNumber(nums));

	}

	public static int singleNumber(int[] nums) {
		int single = 0;
		for (int num : nums) {
			System.out.println("single   " + single + " num   " + num + "  single^num   " + (single ^ num));
			single = single ^ num;
		}
		return single;
	}

}
