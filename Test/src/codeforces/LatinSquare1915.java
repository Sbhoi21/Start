package codeforces;

import java.util.Scanner;

public class LatinSquare1915 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // Number of test cases
		char[] missingLetter = new char[t];
		for (int i = 0; i < t; i++) {
			char[][] grid = new char[3][3];

			// Read the Latin square
			for (int j = 0; j < 3; j++) {
				String row = scanner.next();
				grid[j] = row.toCharArray();
			}
 
			// Find the missing letter
			missingLetter[i] = findMissingLetter(grid);
		}

		for (char c : missingLetter) {
			System.out.println(c);
		}
	}

	private static char findMissingLetter(char[][] grid) {
		// Count occurrences of A, B, and C
		int[] count = new int[3];

		// Count in rows
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (grid[i][j] == 'A')
					count[0]++;
				if (grid[i][j] == 'B')
					count[1]++;
				if (grid[i][j] == 'C')
					count[2]++;
			}
		}

		// Find the letter that appears only once
		char missingLetter = ' ';
		for (int i = 0; i < 3; i++) {
			if (count[i] == 2) {
				if (i == 0)
					missingLetter = 'A';
				if (i == 1)
					missingLetter = 'B';
				if (i == 2)
					missingLetter = 'C';
				break;
			}
		}
		return missingLetter;
	}
}
