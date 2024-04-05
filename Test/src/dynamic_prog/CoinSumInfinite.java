package dynamic_prog;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinSumInfinite {
	static int mod = 1000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.
//		NOTE:
//		Coins in set A will be unique. Expected space complexity of this problem is O(B). The answer can overflow. So, return the answer % (106 + 7).
//
//		Problem Constraints
//		1 <= A <= 500
//		1 <= A[i] <= 1000
//		1 <= B <= 50000
//
//		Input Format
//		First argument is an integer array A representing the set.
//		Second argument is an integer B.
//
//		Output Format
//		Return an integer denoting the number of ways.
//
//		Example Input
//		Input 1:
//		 A = [1, 2, 3]
//		 B = 4
//		Input 2:
//		 A = [10]
//		 B = 10

//		Example Output
//		Output 1://		 4
//		Output 2://		 1

//		int[] A = { 1, 2, 3 };
		int B = 49160;
//		int[] A = { 2, 582, 198, 22, 467, 243, 216, 108, 515, 235, 112, 4, 50,
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 582, 198, 22, 467, 243, 216, 108, 515, 235, 112, 4, 50,
				86, 127, 548, 194, 192, 199, 315, 161, 372, 89, 231, 360, 430, 54, 139, 215, 150, 450, 380, 431, 571,
				129, 555, 361, 504, 300, 513, 74, 59, 136, 272, 596, 424, 466, 239, 553, 585, 330, 341, 186, 563, 335,
				429, 274, 142, 339, 423, 87, 465, 241, 292, 79, 105, 184, 495, 270, 533, 404, 511, 256, 177, 488, 537,
				347, 68, 64, 547, 493, 271, 191, 148, 525, 412, 277, 65, 42, 279, 157, 160, 353, 101, 109, 321, 166,
				368, 223, 255, 395, 565, 506, 427, 156, 80, 254, 561, 383, 575, 228, 268, 327, 538, 260, 162, 472, 8,
				33, 165, 6, 461, 250, 200, 492, 410, 326, 490, 173, 196, 265, 382, 116, 25, 598, 452, 568, 398, 570,
				496, 99, 503, 214, 35, 141, 286, 133, 392, 85, 7, 179, 125, 245, 115, 44, 597, 63, 566, 580, 290, 552,
				458, 55, 73, 312, 413, 309, 263, 293, 114, 316, 487, 97, 567, 448, 144, 3, 269, 589, 318, 298, 16, 203,
				529, 66, 60, 103, 249, 473, 58, 57, 441, 27, 221, 377, 225, 586, 367, 75, 535, 71, 147, 439, 93, 237,
				117, 491, 171, 421, 182, 334, 46, 24, 366, 534, 394, 41, 443, 28, 484, 516, 499, 325, 546, 378, 470,
				227, 436, 110, 266, 23, 599, 476, 51, 175, 172, 267, 539, 435, 311, 508, 153, 600, 317, 387, 190, 303,
				344, 169, 514, 475, 17, 340, 53, 356, 414, 131, 464, 390, 314, 1, 283, 295, 512, 574, 193, 397, 545,
				230, 282, 48, 146, 411, 531, 197, 400, 262, 388, 212, 425, 207, 456, 178, 299, 209, 422, 449, 373, 486,
				588, 564, 346, 578, 61, 482, 437, 333, 107, 455, 556, 137, 480, 528, 111, 151, 39, 5, 469, 517, 143,
				440, 119, 278, 502, 385, 527, 49, 442, 273, 419, 521, 258, 457, 343, 401, 124, 478, 281, 205, 445, 379,
				352, 562, 544, 180, 485, 122, 319, 541, 78, 584, 91, 543, 251, 130, 336, 519, 43, 420, 248, 15, 138,
				331, 31, 159, 163, 454, 572, 113, 104, 287, 408, 244, 359, 399, 280, 510, 530, 406, 12, 501, 201, 355,
				593, 92, 222, 350, 559, 181, 291, 497, 187, 324, 261, 167, 224, 549, 323, 536, 18, 232, 14, 540, 358,
				90, 10, 188, 252, 453, 489, 403, 170, 518, 520, 289, 296, 98, 297, 26, 306, 554, 381, 474, 264, 229, 52,
				285, 391, 375, 100, 328, 242, 307, 83, 96, 102, 481, 460, 185, 37, 67, 132, 149, 202, 402, 494, 446, 76,
				276, 569, 329, 364, 396, 152, 432, 551, 195, 206, 415, 451, 47, 581, 69, 275, 302, 123, 592, 426, 526,
				459, 384, 29, 40, 72, 573, 577, 428, 211, 557, 345, 134, 82, 365, 218, 463, 407, 418, 305 ));

	System.out.println(coinchange2(A, B));
	}

	public static int coinchange2(int[] A, int B) {
		int n = A.length;
		int[][] dp = new int[n + 1][B + 1];
		for (int i = 0; i <= n; i++)
			Arrays.fill(dp[i], -1);
		return count(A, B, dp, n-1);
	}

	private static int count(int[] a, int b, int[][] dp, int i) {
		// TODO Auto-generated method stub
		if (i < 0) {
			return 0;
		}
		if (b == 0) {
			return 1;
		}
		if (dp[i][b] != -1) {
			return dp[i][b];
		}
		int t = 0;
		if (b - a[i] >= 0) {
			t = count(a, (b - a[i]), dp, i) % mod;
		}
		t += count(a, b, dp, i - 1) % mod;

		return dp[i][b] = t % mod;
	}

//	public static int coinchange2(ArrayList<Integer> A, int B) {
//		int dp[][] = new int[A.size() + 1][B + 1];
//		for (int i = 0; i <= A.size(); i++)
//			Arrays.fill(dp[i], -1);
//		return maxValue(A.size(), dp, B, A);
//	}

	private static int maxValue(int coinRem, int[][] dp, int value, ArrayList<Integer> A) {
		if (value == 0)
			return 1;
		if (coinRem == 0)
			return 0;
		int ans = 0;
		if (dp[coinRem][value] != -1)
			return dp[coinRem][value];
		if (value - A.get(coinRem - 1) >= 0)
			ans = maxValue(coinRem, dp, value - A.get(coinRem - 1), A) % mod;
		ans += maxValue(coinRem - 1, dp, value, A) % mod;
		return dp[coinRem][value] = ans % mod;
	}

//	public static int coinchange2(int[] A, int B) {
//		int dp[][] = new int[A.length + 1][B + 1];
//		for (int i = 0; i <= A.length; i++)
//			Arrays.fill(dp[i], -1);
//		return maxValue(A.length, dp, B, A);
//	}

	private static int maxValue(int coinRem, int[][] dp, int value, int[] A) {
		if (value == 0)
			return 1;
		if (coinRem == 0)
			return 0;
		int ans = 0;
		if (dp[coinRem][value] != -1)
			return dp[coinRem][value];
		if (value - A[coinRem - 1] >= 0)
			ans = maxValue(coinRem, dp, value - A[coinRem - 1], A) % mod;
		ans += maxValue(coinRem - 1, dp, value, A) % mod;
		return dp[coinRem][value] = ans % mod;
	}

	public static int coinchange2(ArrayList<Integer> A, int B) {
		int n = A.size();
		int dp[] = new int[B + 1];
		for (int i = 0; i <= B; i++)
			Arrays.fill(dp, 0);
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= B; j++) {
				int left = 0;
				if (j - A.get(i) >= 0)
					left = dp[j - A.get(i)];
				dp[j] = (dp[j] % mod + left) % mod;
			}
		}
		return dp[B] % mod;
	}
}
