package test_copilot;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3, 2, 2, 3};
		int val = 3;
		System.out.println(removeElement(nums, val));
		
	}

	// time complexity is O(n) and space complexity is O(1)
	public static int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			}
		}
		return i;
	}
	
	// 2nd approach
	public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

}
