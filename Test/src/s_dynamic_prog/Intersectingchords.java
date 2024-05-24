package s_dynamic_prog;

public class Intersectingchords {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		4 --> 1 1 1 1
//		c = n-1;
//		sum = 0;
//		dp[0] = 1;
//		dp[1] = 1;
//		for (int i = 0; i < n; i++) {
//			sum += (dp[i] * dp[c]);
//			c--;
//		}
//		dp[n] = sum;
//
//
//
//		Q2. Intersecting Chords in a Circle
//		Unsolved
//		feature icon
//		Using hints is now penalty free
//		Use Hint
//		Problem Description
//		Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.
//
//		Two ways are different if there exists a chord which is present in one way and not in other.
//		Return the answer modulo 109 + 7.
//
//		Problem Constraints
//		1 <= A <= 103
//
//		Input Format
//		The first and the only argument contains the integer A.
//
//		Output Format
//		Return an integer answering the query as described in the problem statement.
//
//
//		Input 1:		 A = 1
//		Input 2:		 A = 2
//
//		Output 1://		 1
//		Output 2://		 2
//
//		Example Explanation
//		Explanation 1:
//		 If points are numbered 1 to 2 in clockwise direction, then different ways to draw chords are: {(1-2)} only. So, we return 1.
//
//		Explanation 2:
//		 If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
//		 So, we return 2.

		System.out.println(chordCnt(22));
	}

	public static int chordCnt(int A) {
		int[] dp = new int[A + 1];

//		dp[19] = 767263183;
//		dp[18] = 477638700;
//		dp[17] = 129644790;
//		dp[16] = 35357670;
//		dp[15] = 9694845;
//		dp[14] = 2674440;
//		dp[13] = 742900;
//		dp[12] = 208012;
//		dp[11] = 58786;
//		dp[10] = 16796;
//		dp[9] = 4862;
//		dp[8] = 1430;
//		dp[7] = 429;
//		dp[6] = 132;
//		dp[5] = 42;
//		dp[4] = 14;
//		dp[3] = 5;
//		dp[2] = 2;
		dp[1] = 1;
		dp[0] = 1;

		return count(dp, A) % MOD;
	}

	private static int count(int[] dp, int c) {
		// TODO Auto-generated method stub
		long sum = 0;
		if (dp[c] != 0) {
			return dp[c];
		}
		for (int i = 0; i < c; i++) {
			long n = (long) dp[i] * count(dp, c - 1 - i);
			System.out.println("n                       --> " + n);
			sum = (sum + n) % MOD;
			System.out.println("summmm    " + i + ":: " + sum);
		}
		dp[c] = (int) sum % MOD;
		return dp[c];
	}

	public static int chordCnt3(int A) {
		int[] dp = new int[A + 1];
		int mod = 1000000007;
//		dp[19] = 767263183;
//		dp[18] = 477638700;
//		dp[17] = 129644790;
//		dp[16] = 35357670;
//		dp[15] = 9694845;
//		dp[14] = 2674440;
//		dp[13] = 742900;
//		dp[12] = 208012;
//		dp[11] = 58786;
//		dp[10] = 16796;
//		dp[9] = 4862;
//		dp[8] = 1430;
//		dp[7] = 429;
//		dp[6] = 132;
//		dp[5] = 42;
//		dp[4] = 14;
//		dp[3] = 5;
//		dp[2] = 2;
//		dp[1] = 1;
//		dp[0] = 1;
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= A; i++) {
			long val = 0;
			for (int j = 0; j < (i / 2); j++) {
				System.out.println("before:: " + j + ":: " + val);
				int n = dp[j] * dp[i - 1 - j];
				System.out.println("n                 --> " + n);
				val = (val + (long) n) % mod;
				System.out.println("summmm    " + j + ":: " + val);
			}
			val = val * 2;
			if (i % 2 != 0) {
				val += (dp[i / 2] * dp[i / 2]);
			}
			dp[i] = (int) val;
			System.out.println(i + "  " + val);
		}
		return dp[A] % mod;
	}

//	private static int count(int[] dp, int c) {
//		// TODO Auto-generated method stub
//		System.out.println(c);
//		int sum = 0;
//		if (dp[c] != 0) {
//			System.out.println("dppp " + c + "   _  " + dp[c]);
//			return dp[c];
//		}
//		int n = c;
//		for (int i = 0; i < c; i++) {
//			sum += (dp[i] * count(dp, n - 1));
//			n--;
//		}
//		dp[c] = sum % MOD;
//		return dp[c];
//	}

	public static int chordCnt1(int A) {
		int[] dp = new int[A + 1];
		int mod = 1000000007;
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= A; i++) {
			long val = 0;
			for (int j = 0; j < i; j++) {
				System.out.println("before:: " + j + ":: " + val);
				long n = (long) dp[j] * dp[i - 1 - j];
				System.out.println("n                 --> " + n);
				val = (val + n) % mod;
				System.out.println("summmm    " + j + ":: " + val);

//				val = (val + (long) dp[j] * dp[i - 1 - j]) % mod;
			}
			dp[i] = (int) val;
		}
		return dp[A];
	}

}
