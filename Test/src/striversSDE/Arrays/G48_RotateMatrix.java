package striversSDE.Arrays;

public class G48_RotateMatrix {

	public static void rotateMatrix(int[][] matrix) {
		int n = matrix.length;

		// Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

//	      {1, 2, 3}				{9, 6, 3}
//        {4, 5, 6}		=> 		{8, 5, 2}
//        {7, 8, 9}				{7, 4, 1}

		// Reverse the rows
		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = n - 1;
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
//			{9, 6, 3}				{7, 4, 1}
//			{8, 5, 2}		=> 		{8, 5, 2}
//			{7, 4, 1}				{9, 6, 3}
	}

	public static void printMatrix(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println("Original Matrix:");
		printMatrix(matrix);

		rotateMatrix(matrix);

		System.out.println("\nMatrix Rotated by 90 Degrees:");
		printMatrix(matrix);
	}

}
