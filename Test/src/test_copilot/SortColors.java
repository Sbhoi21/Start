package test_copilot;

public class SortColors {

	// Lc. 75 Sort Colors
	public static void main(String[] args) {
		
	}
	
	public static void sortColors(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int i = 0;
		while (i <= high) {
			if (nums[i] == 0) {
				swap(nums, i, low);
				i++;
				low++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, i, high);
				high--;
			}
		}
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
