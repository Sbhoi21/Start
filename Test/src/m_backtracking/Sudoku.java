package m_backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sudoku {

	public static Map<Integer, Set<Integer>> rowMap = new HashMap<>();
	public static Map<Integer, Set<Integer>> colMap = new HashMap<>();
	public static Map<String, Set<Integer>> boxMap = new HashMap<>();

	public static void main(String[] args) {
		int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

//		3 1 6 5 7 8 4 9 2
//		5 2 9 1 3 4 7 6 8
//		4 8 7 6 2 9 5 3 1
//		2 6 3 4 1 5 9 8 7
//		9 7 4 8 6 3 1 2 5
//		8 5 1 7 9 2 6 4 3
//		1 3 8 9 4 7 2 5 6
//		6 9 2 3 5 1 8 7 4
//		7 4 5 2 8 6 3 1 9

		createGrid(grid);

//		System.out.println(rowMap);
//		System.out.println(colMap);
//		System.out.println(boxMap);

		if (solveSudoku(grid, 0, 0))
			print(grid);
		else
			System.out.println("No Solution exists");
	}

	public static boolean solveSudoku(int grid[][], int row, int col) {

		if (col == 9) {
			col = 0;
			row++;
		}
		if (row == 9) {
			return true;
		}
		if (grid[row][col] != 0) {
			return solveSudoku(grid, row, col + 1);

		} else {

			for (int i = 1; i < 10; i++) {

				if (verify(row, col, i)) {
					grid[row][col] = i;
					if (solveSudoku(grid, row, col + 1)) {
						return true;
					}
				}
				int v = grid[row][col];
				grid[row][col] = 0;
				undone(v, row, col);

			}
		}
		return false;

	}

	static boolean verify(int row, int col, int value) {

		int br = row - row % 3;
		int bc = col - col % 3;
		if (rowMap.get(row) == null) {
			rowMap.put(row, new HashSet<>());
		}
		if (colMap.get(col) == null) {
			colMap.put(col, new HashSet<>());
		}
		if (boxMap.get(br + "_" + bc) == null) {
			boxMap.put(br + "_" + bc, new HashSet<>());
		}

		if (!(rowMap.get(row).contains(value) || colMap.get(col).contains(value)
				|| boxMap.get(br + "_" + bc).contains(value)))

		{
			rowMap.get(row).add(value);
			colMap.get(col).add(value);
			boxMap.get(br + "_" + bc).add(value);
			return true;
		}

		return false;

	}

	static void undone(int value, int row, int col) {

		int br = row - row % 3;
		int bc = col - col % 3;
		rowMap.get(row).remove(value);
		colMap.get(col).remove(value);
		boxMap.get(br + "_" + bc).remove(value);

	}

	private static void createGrid(int[][] grid) {
		// TODO Auto-generated method stub

		int row = 0;
		for (int col = 0;; col++) {
			if (col == 9) {
				col = 0;
				row++;
			}
			if (row == 9) {
				break;
			}

			int br = row - row % 3;
			int bc = col - col % 3;
			if (rowMap.get(row) == null) {
				rowMap.put(row, new HashSet<>());
			}
			if (colMap.get(col) == null) {
				colMap.put(col, new HashSet<>());
			}
			if (boxMap.get(br + "_" + bc) == null) {
				boxMap.put(br + "_" + bc, new HashSet<>());
			}
			int value = grid[row][col];
			if (value > 0) {
				rowMap.get(row).add(value);
				colMap.get(col).add(value);
				boxMap.get(br + "_" + bc).add(value);

			}

		}

	}

	static void print(int[][] grid) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + "\t");
			}
			System.out.println("");
		}

	}

}
