package striversSDE.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B118PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an integer numRows, return the first numRows of Pascal's triangle.
//		In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

//				Example 1:
//				Input: numRows = 5
//				Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//				Example 2:
//				Input: numRows = 1
//				Output: [[1]]

		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> l = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l.add(l1);
		System.out.println(l.get(0));
		for (int i = 1; i < numRows; i++) {
			List<Integer> li = new ArrayList<>();
			li.add(1);
			for (int j = 1; j < i; j++) {
				li.add(l.get(i - 1).get(j - 1) + l.get(i - 1).get(j));
			}
			li.add(1);
			l.add(li);
		}
		return l;
	}

	public List<List<Integer>> generate1(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if (numRows == 0) {
			return result;
		}

		if (numRows == 1) {
			List<Integer> firstRow = new ArrayList<>();
			firstRow.add(1);
			result.add(firstRow);
			return result;
		}

		result = generate(numRows - 1);
		List<Integer> prevRow = result.get(numRows - 2);
		List<Integer> currentRow = new ArrayList<>();
		currentRow.add(1);

		for (int i = 1; i < numRows - 1; i++) {
			currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
		}

		currentRow.add(1);
		result.add(currentRow);

		return result;
	}

	public List<List<Integer>> generate3(int numRows) {
		if (numRows == 0)
			return new ArrayList<>();
		if (numRows == 1) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(Arrays.asList(1));
			return result;
		}

		List<List<Integer>> prevRows = generate(numRows - 1);
		List<Integer> newRow = new ArrayList<>();

		for (int i = 0; i < numRows; i++) {
			newRow.add(1);
		}

		for (int i = 1; i < numRows - 1; i++) {
			newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
		}

		prevRows.add(newRow);
		return prevRows;
	}

	// optimal
	// tc-o(n*n) sc-o(1)
	public List<List<Integer>> generate2(int numRows) {
		List<List<Integer>> ans = new ArrayList<>();

		for (int row = 1; row <= numRows; row++) {
			ans.add(generateRow(row));
		}
		return ans;
	}

	public List<Integer> generateRow(int row) {
		long res = 1;
		List<Integer> small = new ArrayList<>();
		small.add(1);

		for (int col = 1; col < row; col++) {
			res *= (row - col);
			res /= col;
			small.add((int) res);
		}
		return small;
	}

}
