package codeforces;

import java.util.Scanner;

public class MedianMaximization1566 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt(); // Number of test cases
		int[] arr = new int[t];
		while (t-- > 0) {
			int n = scanner.nextInt(); // Length of the array
			int s = scanner.nextInt(); // Required sum of elements
			int median;
			median = s / ((n / 2) + 1);

			arr[t] = median;
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
}
