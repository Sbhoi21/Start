package dynamic_prog;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathTringle {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

//		Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//		Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
//
//		Problem Constraints
//		|A| <= 1000
//
//		A[i] <= 1000

//		
//		Input 1:
//
//			A = [ 
//			         [2],
//			        [3, 4],
//			       [6, 5, 7],
//			      [4, 1, 8, 3]
//			    ]
//			Output :			 11

		ArrayList<ArrayList<Integer>> l = new ArrayList<>();
		l.add(new ArrayList(Arrays.asList(2)));
		l.add(new ArrayList(Arrays.asList(3, 4)));
		l.add(new ArrayList(Arrays.asList(6, 5, 7)));
		l.add(new ArrayList(Arrays.asList(4, 1, 8, 3)));
		l.add(new ArrayList(Arrays.asList(4, 1, 8, 3)));
//		l.add(new ArrayList(Arrays.asList(6, 6, 1, 1)));
//		l.add(new ArrayList(Arrays.asList(7, 8)));

		System.out.println(minimumTotal(l));

	}

	public static int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		int[][] dp = new int[n + 1][n + 1];
		return count(a, dp, 0, 0);
	}

	private static int count(ArrayList<ArrayList<Integer>> a, int[][] dp, int i, int j) {
		// TODO Auto-generated method stub
//		if (a.get(i) == null || a.get(i).get(j) == null) {
//			return 0;
//		}
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		if (i == a.size() - 1) {
			return a.get(i).get(j);
		}
		int sum = a.get(i).get(j) + Math.min(count(a, dp, i + 1, j), count(a, dp, i + 1, j + 1));
		dp[i][j] = sum;
		return sum;
	}

}
