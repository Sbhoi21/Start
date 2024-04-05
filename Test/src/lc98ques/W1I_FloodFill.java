package lc98ques;

import java.util.LinkedList;
import java.util.Queue;

public class W1I_FloodFill {

	public static void main(String[] args) {

		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		show(image);
		System.out.println();
		floodFill1(image, sr, sc, color);
		show(image);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] == color)
			return image;
		fill(image, sr, sc, image[sr][sc], color);
		return image;
	}

	private static void fill(int[][] image, int sr, int sc, int oldColor, int newColor) {
		// TODO Auto-generated method stub
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor) {
			return;
		}
		image[sr][sc] = newColor;
		fill(image, sr - 1, sc, oldColor, newColor);
		fill(image, sr + 1, sc, oldColor, newColor);
		fill(image, sr, sc - 1, oldColor, newColor);
		fill(image, sr, sc + 1, oldColor, newColor);
	}

	static void show(int[][] image) {
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[i].length; j++) {
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
		int originalColor = image[sr][sc];
		if (originalColor == newColor) {
			return image;
		}

		int rows = image.length;
		int cols = image[0].length;
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

		Queue<int[]> queue = new LinkedList();
		queue.offer(new int[] { sr, sc });

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];

			image[r][c] = newColor;

			for (int[] dir : directions) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == originalColor) {
					queue.offer(new int[] { nr, nc });
				}
			}
		}

		return image;
	}
}