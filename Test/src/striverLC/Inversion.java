package striverLC;

public class Inversion {

//	https://www.codingninjas.com/studio/problems/count-inversions_615?count=25&page=34&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=PROBLEM

//	
//	Problem statement
//	For a given integer array/list 'ARR' of size 'N' containing all distinct values, find the total number of 'Inversions' that may exist.
//
//	An inversion is defined for a pair of integers in the array/list when the following two conditions are met.
//
//	A pair ('ARR[i]', 'ARR[j]') is said to be an inversion when:
//
//	1. 'ARR[i] > 'ARR[j]' 
//	2. 'i' < 'j'
//
//	Where 'i' and 'j' denote the indices ranging from [0, 'N').
//	Detailed explanation ( Input/output format, Notes, Images )
//	Constraints :
//	1 <= N <= 10^5 
//	1 <= ARR[i] <= 10^9
//
//	Where 'ARR[i]' denotes the array element at 'ith' index.
//
//	Time Limit: 1 sec
//	Sample Input 1 :
//	3
//	3 2 1
//	Sample Output 1 :
//	3
//	Explanation of Sample Output 1:
//	We have a total of 3 pairs which satisfy the condition of inversion. (3, 2), (2, 1) and (3, 1).
//	Sample Input 2 :
//	5
//	2 5 1 3 4
//	Sample Output 2 :
//	4
//	Explanation of Sample Output 1:
//	We have a total of 4 pairs which satisfy the condition of inversion. (2, 1), (5, 1), (5, 3) and (5, 4).

	public static long getInversions(long arr[], int n) {
		// Write your code here.
		long[] temp = new long[n];
		return mergeSortAndCount(arr, temp, 0, n - 1);
	}

	private static long mergeSortAndCount(long[] arr, long[] temp, int left, int right) {
		long inversions = 0;
		if (left < right) {
			int mid = (left + right) / 2;

			inversions += mergeSortAndCount(arr, temp, left, mid);
			inversions += mergeSortAndCount(arr, temp, mid + 1, right);

			inversions += merge(arr, temp, left, mid, right);
		}
		return inversions;
	}

	private static long merge(long[] arr, long[] temp, int left, int mid, int right) {
		long inversions = 0;
		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversions += mid - i + 1;
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (i = left; i <= right; i++) {
			arr[i] = temp[i];
		}

		return inversions;
	}

	public static void main(String[] args) {
		long[] arr1 = { 3, 2, 1 };
		int n1 = arr1.length;
		System.out.println(getInversions(arr1, n1)); // Output: 3

		long[] arr2 = { 2, 5, 1, 3, 4 };
		int n2 = arr2.length;
		System.out.println(getInversions(arr2, n2));
	}

}
