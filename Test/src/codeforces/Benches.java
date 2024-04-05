package codeforces;

import java.util.Scanner;

public class Benches {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // Number of benches
		int m = scanner.nextInt(); // Number of additional people

		int[] benches = new int[n];
		int maxInitialPeople = Integer.MIN_VALUE; // Changed to maxInitialPeople
		int totalInitialPeople = 0;

		for (int i = 0; i < n; i++) {
			benches[i] = scanner.nextInt();
			maxInitialPeople = Math.max(maxInitialPeople, benches[i]); // Updated to maxInitialPeople
			totalInitialPeople += benches[i];
		}

		// Calculate minimum possible k
		int minK = Math.max(maxInitialPeople, (totalInitialPeople + m + n - 1) / n);
		; // Minimum possible k is the maximum initial occupancy

		int maxK = benches[0];

		// Calculate maximum possible k
		for (int i = 0; i < benches.length; i++) {
			maxK = Math.max(benches[i], maxK);
		}

		System.out.println(minK + " " + (maxK + m));
	}
}
