package a_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermuteArray {
	public static List<List<Integer>> permuteArrays(int[] arr1, int[] arr2) {
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> permutation = new ArrayList<>();
		permute(arr1, arr2, 0, 0, permutation, permutations);
		return permutations;
	}

	private static void permute(int[] arr1, int[] arr2, int i, int j, List<Integer> permutation,
			List<List<Integer>> permutations) {
		if (i == arr1.length && j == arr2.length) {
			permutations.add(new ArrayList<>(permutation));
			return;
		}

		if (i < arr1.length) {
			permutation.add(arr1[i]);
			permute(arr1, arr2, i + 1, j, permutation, permutations);
			permutation.remove(permutation.size() - 1);
		}

		if (j < arr2.length) {
			permutation.add(arr2[j]);
			permute(arr1, arr2, i, j + 1, permutation, permutations);
			permutation.remove(permutation.size() - 1);
		}
	}

	public static List<List<Integer>> permuteTwoArrays(int[] arr1, int[] arr2) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				List<Integer> permutation = new ArrayList<>();
				permutation.add(arr1[i]);
				permutation.add(arr2[j]);
				result.add(permutation);
			}
		}
		return result;
	}

	public static String twoArrays(int k, int[] A, int[] B) {
		// Sort arrays A and B
		Arrays.sort(A);
		Arrays.sort(B);

		// Check if the relation holds for each pair of elements
		for (int i = 0; i < A.length; i++) {
			if (A[i] + B[B.length - 1 - i] < k) {
				return "NO";
			}
		}

		return "YES";
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 5 };
		int[] arr2 = { 3, 4 };
		String result = twoArrays(5, arr1, arr2);
		System.out.println("Permutations of two arrays: ");
		System.out.println(result);
//		for (List<Integer> permutation : result) {
//			System.out.println(permutation);
//		}
	}
}
