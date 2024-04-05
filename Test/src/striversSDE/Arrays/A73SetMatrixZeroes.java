package striversSDE.Arrays;


public class A73SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

//		Example 1:
//		Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//		Output: [[1,0,1],[0,0,0],[1,0,1]]
//		
//		Example 2:
//		Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//		Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		showMat(matrix);
		setZeroes(matrix);
	}

	public static void setZeroes(int[][] matrix) {

		boolean fr = false, fc = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						fr = true;
					if (j == 0)
						fc = true; 
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (fr) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
		}
		if (fc) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void showMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}
