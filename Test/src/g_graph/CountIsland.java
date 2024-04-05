package g_graph;

public class CountIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mat[][] = new int[5][5];

		mat[0][0] = 1;
		mat[0][1] = 1;
		mat[1][1] = 1;
		mat[0][4] = 1;
		mat[0][1] = 1;
		mat[1][3] = 1;
		mat[1][4] = 1;
		mat[2][0] = 1;
		mat[2][1] = 1;
		mat[4][0] = 1;
		mat[3][1] = 1;
		mat[4][2] = 1;
		mat[4][3] = 1;
		mat[4][4] = 1;

		System.out.println(count(mat));

	}

	private static int count(int[][] mat) {
		// TODO Auto-generated method stub

		int n = mat.length;
		int m = mat[0].length;
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 1) {
					c++;
					dfs(mat, i, j);
				}
			}
		}

		return c;

	}

	private static void dfs(int[][] mat, int i, int j) {
		// TODO Auto-generated method stub
		if (j < 0 || i < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) {
			return;
		}
		mat[i][j] = 0;
		dfs(mat, i + 1, j);
		dfs(mat, i, j + 1);
		dfs(mat, i - 1, j);
		dfs(mat, i, j - 1);
	}

}
