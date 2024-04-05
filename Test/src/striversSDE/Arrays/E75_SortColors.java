package striversSDE.Arrays;

public class E75_SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//		We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//		You must solve this problem without using the library's sort function.

//		Example 1:
//		Input: nums = [2,0,2,1,1,0]
//		Output: [0,0,1,1,2,2]
//		Example 2:
//		Input: nums = [2,0,1]
//		Output: [0,1,2]

//		Constraints:
//		n == nums.length
//		1 <= n <= 300
//		nums[i] is either 0, 1, or 2.

		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int N = arr.length;

		// Function call
		quickSort(arr, 0, N - 1);
		System.out.println("Sorted array:");
		printArr(arr); 
	}

	public static void sortColors(int[] nums) {

	}

	// A utility function to swap two elements
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// This function takes last element as pivot,
	// places the pivot element at its correct position
	// in sorted array, and places all smaller to left
	// of pivot and all greater elements to right of pivot
	static int partition(int[] arr, int low, int high) {
		// Choosing the pivot
		int pivot = arr[high];

		// Index of smaller element and indicates
		// the right position of pivot found so far
		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			// If current element is smaller than the pivot
			if (arr[j] < pivot) {

				// Increment index of smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	// The main function that implements QuickSort
	// arr[] --> Array to be sorted,
	// low --> Starting index,
	// high --> Ending index
	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {

			// pi is partitioning index, arr[p]
			// is now at right place
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	// To print sorted array
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
