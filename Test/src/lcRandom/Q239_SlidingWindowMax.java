package lcRandom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q239_SlidingWindowMax {

//	
//	You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//	Return the max sliding window.

//	Example 1:
//	Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//	Output: [3,3,5,5,6,7]
//
//	Explanation: 
//	Window position                Max
//	---------------               -----
//	[1  3  -1] -3  5  3  6  7       3
//	 1 [3  -1  -3] 5  3  6  7       3
//	 1  3 [-1  -3  5] 3  6  7       5
//	 1  3  -1 [-3  5  3] 6  7       5
//	 1  3  -1  -3 [5  3  6] 7       6
//	 1  3  -1  -3  5 [3  6  7]      7
//
//	Example 2:
//	Input: nums = [1], k = 1
//	Output: [1]

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(maxSlidingWindow(nums, 3));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> queue = new ArrayDeque<>();
		List<Integer> li = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.removeLast();
			}
			queue.add(i);
			if (queue.peek() == i - k) {
				queue.remove();
			}
			if (i - k >= -1) {
				li.add(nums[queue.peek()]);
			}
			System.out.println(li);
		}
		int[] a = li.stream().mapToInt(Integer::intValue).toArray();
		return a;
	}

}
