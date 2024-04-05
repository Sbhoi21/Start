package codeforces;

import java.util.Scanner;

public class FindMax1527 {

	// Function to find the maximum k such that n & (n-1) & ... & k = 0
	public static int findMaximumK(int n) {
		int k = n-1;
		int b = n & k;
		while ( b != 0) {
			k--;
			b = b & k;
		}
		return k;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Input the number of test cases
		int t = scanner.nextInt();

		// Process each test case
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			int k = findMaximumK(n);
			System.out.println(k);
		}
	}
}
