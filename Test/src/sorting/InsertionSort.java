package sorting;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int current = arr[i];
			int j = i - 1;

			// Shift elements of the sorted part of the array that are greater than the
			// current element
			while (j >= 0 && arr[j] > current) {
				arr[j + 1] = arr[j];
				j--;
			}

			// Place the current element in its correct position in the sorted part of the
			// array
			arr[j + 1] = current;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 11, 13, 5, 6 };

		System.out.println("Original Array:");
		printArray(arr);

		insertionSort(arr);

		System.out.println("\nArray after Insertion Sort:");
		printArray(arr);
	}

	public static void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
