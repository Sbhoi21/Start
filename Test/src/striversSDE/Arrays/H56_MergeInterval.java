package striversSDE.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class H56_MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//				Example 1:
//				Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//				Output: [[1,6],[8,10],[15,18]]
//				Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

//				Example 2: 
//				Input: intervals = [[1,4],[4,5]]
//				Output: [[1,5]]
//				Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//				Constraints:
//				1 <= intervals.length <= 104 
//				intervals[i].length == 2
//				0 <= starti <= endi <= 104

//		int[][] intervals = { { 1, 4 }, { 4, 5 } };
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] result = merge(intervals);

		for (int[] is : result) {
			for (int is2 : is) {
				System.out.print(is2+ "  ");
			}
			System.out.println("");
		}
	}

	public static int[][] merge(int[][] intervals) {

		if (intervals == null || intervals.length == 0) {
			return new int[0][];
		}

		// Sort the intervals by their start points
//		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 	// 	took 9msz
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // took 7ms

		List<int[]> mergedIntervals = new ArrayList<>();
		int[] currentInterval = intervals[0];

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= currentInterval[1]) {
				// Merge overlapping intervals
				currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
			} else {
				// Current interval doesn't overlap with the next one
				mergedIntervals.add(currentInterval);
				currentInterval = intervals[i];
			}
		}

		// Add the last merged or single interval
		mergedIntervals.add(currentInterval);
		System.out.println(mergedIntervals);
		return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
	}

}
