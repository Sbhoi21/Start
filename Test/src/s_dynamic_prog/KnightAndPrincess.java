package s_dynamic_prog;

public class KnightAndPrincess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//
//		The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//
//		Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//
//		In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//
//		Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.

//		Input 1:
//		 A = [ 
//		       [-2, -3, 3],
//		       [-5, -10, 1],
//		       [10, 30, -5]
//		     ]
//		Input 2:
//		 A = [ 
//		       [1, -1, 0],
//		       [-1, 1, -1],
//		       [1, 0, -1]
//		     ]
//
//		Example Output
//		Output 1: 7
//		Output 2: 1

		int[][] A = { { -2, -3, 3 },
				{ -5, -10, 1 }, 
				{ 10, 30, -5 } };

		System.out.println(calculateMinimumHP(A));

	}

	public static int calculateMinimumHP(int[][] A) {

		int n = A.length;
		int m = A[0].length;

		int dp[][] = new int[n+1][m+1];
		
		dp[n - 1][m - 1] = Math.min(0, A[n - 1][m - 1]);

//		for (int i = n - 2; i >= 0; i--) {
//			dp[i][m - 1] = Math.min(0, A[i][m - 1] + dp[i + 1][m - 1]);
//		}
//		for (int i = m - 2; i >= 0; i--) {
//			dp[n - 1][i] = Math.min(0, A[n - 1][i] + dp[n - 1][i + 1]);
//		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				dp[i][j] = Math.min(0, A[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]));
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}

		return (dp[0][0] * -1) + 1;

	}

}
