package subarray;

import java.util.Arrays;

public class ThreePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
//		Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
//
//				Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
//				Output: true
//				Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//				Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
//				Output: false
//
//				Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
//				Output: true
//				Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//				 
//				Constraints:
//				3 <= arr.length <= 5 * 104
//				-104 <= arr[i] <= 104

		int[] arr = { 0, 0, 0, 0 };
		System.out.println(canThreePartsEqualSum(arr));
	}

	public static boolean canThreePartsEqualSum(int[] arr) {

		int n = arr.length;
		int[] pre = new int[n];
		pre[0] = arr[0];
		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + arr[i];
			System.out.println(i + "--> " + pre[i]);
		}
		System.out.println(pre[n - 1]);
		if (pre[n - 1] % 3 == 0) {
			int part = pre[n - 1] / 3;
			int i1 = -1;
			int i2 = -1;
			int i = 0;
			while (i < n) {
				if (pre[i] == part) {
					i1 = i;
					i++;
					break;
				}
				i++;
			}
			while (i < n) {
				if (pre[i] == part) {
					i2 = i;
					break;
				}
				i++;
			}

			System.out.println(part + "  " + i1 + "  " + i2);
			if (i1 > -1 && i2 > -1 && i1 < i2) {
				return true;
			}
		}
		return false;
	}

}
