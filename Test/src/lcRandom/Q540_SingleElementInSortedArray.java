package lcRandom;

public class Q540_SingleElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//		Return the single element that appears only once.
//
//		Your solution must run in O(log n) time and O(1) space.
//
//		 
//
//		Example 1:
//
//		Input: nums = [1,1,2,3,3,4,4,8,8]
//		Output: 2
//		Example 2:
//
//		Input: nums = [3,3,7,7,10,11,11]
//		Output: 10
//		 
//
//		Constraints:
//
//		1 <= nums.length <= 105
//		0 <= nums[i] <= 105
		
		
		int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		System.out.println(singleNonDuplicate(nums));
		
	}
	
	// O(log n) time and O(1) space
	public static int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			boolean halvesEven = (high - mid) % 2 == 0;
			if (nums[mid + 1] == nums[mid]) {
				if (halvesEven) {
					low = mid + 2;
				} else {
					high = mid - 1;
				}
			} else if (nums[mid - 1] == nums[mid]) {
				if (halvesEven) {
					high = mid - 2;
				} else {
					low = mid + 1;
				}
			} else {
				return nums[mid];
			}
		}
		return nums[low];
	}
	
	
	// brute force
	public static int singleNonDuplicate2(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; i += 2) {
			if (i == n - 1 || nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return -1;
	}
	
	//most optimized
	public static int singleNonDuplicate3(int[] nums) {
		int n = nums.length;
		int low = 0, high = n - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (mid % 2 == 1)
				mid--;
			if (nums[mid] == nums[mid + 1]) {
				low = mid + 2;
			} else {
				high = mid;
			}
		}
		return nums[low];
	}

}
