package randomYT.Codebix;

import java.util.ArrayList;
import java.util.List;

public class Q442_FindAllDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		
		List<Integer> res = new Q442_FindAllDuplicate().findDuplicates(nums);
	}
	
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int realNum = nums[i] < 0 ? -nums[i] : nums[i];
            int index = realNum - 1;
			if (nums[index] < 0) {
				res.add(index + 1);
			}
			nums[index] = -nums[index];
		}
		return res;
	}

}
