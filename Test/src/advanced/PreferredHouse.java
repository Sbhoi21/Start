package advanced;

import java.awt.geom.Area;
import java.util.LinkedList;
import java.util.Queue;

public class PreferredHouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		There will be list of array. Each index act as an area and each area has a house. Also area contains some other facilities like school, office, gym and park, etc. each will be represented in an index of an array and availibility by 0 or 1. We have to find a most efficient area to buy a house. The most efficient area is the one which has all the facilities in the nearest area. like all the facilities are in the nearby area.
//				Example: areas = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 1, 0 } };
//		int[] house = { 0, 2 ,3};
//		Output: 1 (2nd area, As all the facilities are in the nearby area)
//		Note: house = { 0, 2 ,3} means have to see 0th, 2nd and 3rd index of each areas for preferred house.
//		Explaination: 2nd area is preferred coz 0th, 2nd and 3rd index are less than all others areas. As 0th index is 1 means it is present, 2nd index is 0 means it is not present but it present in just one index ahead, 3rd index is 1 means it is present. So, all the facilities are in the nearby area within 1 steps.

		int[][] areas = { { 1, 1, 0, 1 }, { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 1 } };
		int[] house = { 0, 2, 3 };

		int result = findPreferredHouseOptimized(areas, house);
	}

	public static int findPreferredHouse(int[][] areas, int[] house) {

		int[][] preferredArea = new int[areas.length][house.length + 1];
		int preferredAreaIndex = 0;

		// checking facilities of 1st area, puting int max value if facility is not
		// available
		for (int i = 0; i < house.length; i++) {
			if (areas[0][house[i]] == 1) {
				preferredArea[0][i] = 0;
			} else {
				preferredArea[0][i] = Integer.MAX_VALUE;
			}
			preferredArea[0][house.length] = Integer.MAX_VALUE;
		}

		System.out.println("Area: 0 " + preferredArea[0][0] + " " + preferredArea[0][1] + " " + preferredArea[0][2]
				+ " " + preferredArea[0][3]);

		// checking facilities with going forward
		for (int i = 1; i < areas.length; i++) {
			for (int j = 0; j < house.length; j++) {
				if (areas[i][house[j]] == 1) {
					preferredArea[i][j] = 0;
				} else {
					preferredArea[i][j] = preferredArea[i - 1][j] != Integer.MAX_VALUE ? preferredArea[i - 1][j] + 1
							: Integer.MAX_VALUE;
				}
				preferredArea[i][house.length] = Integer.max(preferredArea[i][house.length], preferredArea[i][j]);
			}
			if (preferredArea[i][house.length] < preferredArea[preferredAreaIndex][house.length]) {
				preferredAreaIndex = i;
			}
			System.out.println("Area: " + i + " " + preferredArea[i][0] + " " + preferredArea[i][1] + " "
					+ preferredArea[i][2] + " " + preferredArea[i][3]);
		}

		// checking facilities with going backward
		for (int i = areas.length - 2; i >= 0; i--) {
			for (int j = 0; j < house.length; j++) {
				if (preferredArea[i][j] > preferredArea[i + 1][j] + 1) {
					preferredArea[i][j] = preferredArea[i + 1][j] + 1;
				}
				// preferedareaIndex will be the minimum of the maximum value of the area
				preferredArea[i][house.length] = Integer.max(preferredArea[i][house.length], preferredArea[i][j]);
			}
			if (preferredArea[i][house.length] < preferredArea[preferredAreaIndex][house.length]) {
				preferredAreaIndex = i;
			}

			System.out.println("Area: " + i + " " + preferredArea[i][0] + " " + preferredArea[i][1] + " "
					+ preferredArea[i][2] + " " + preferredArea[i][3] + "    " + preferredAreaIndex);
		}
		System.out.println(preferredAreaIndex);
		return preferredAreaIndex;

	}

	// optimized code
	public static int findPreferredHouseOptimized(int[][] areas, int[] house) {

		int n = areas.length;
		int m = house.length;
		int[] minDistance = new int[n];
		int[] maxDistance = new int[n];

		// Initialize minDistance to a large number
		for (int i = 0; i < n; i++) {
			minDistance[i] = Integer.MAX_VALUE;
		}

		// For each area, calculate the distance to the nearest required facility
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (areas[i][house[j]] == 1) {
					minDistance[i] = 0;
				} else {
					// BFS to find the nearest facility
					minDistance[i] = bfsDistance(areas, house[j], i);
				}
			}
			maxDistance[i] = minDistance[i];
		}

		// Find the area with the minimum maximum distance
		int preferredAreaIndex = 0;
		for (int i = 1; i < n; i++) {
			if (maxDistance[i] < maxDistance[preferredAreaIndex]) {
				preferredAreaIndex = i;
			}
		}
		System.out.println(preferredAreaIndex);
		return preferredAreaIndex;
	}

	// Function to perform BFS and find the nearest facility distance
	private static int bfsDistance(int[][] areas, int facilityIndex, int startArea) {
		int n = areas.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		int distance = 0;

		queue.add(startArea);
		visited[startArea] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int current = queue.poll();
				if (areas[current][facilityIndex] == 1) {
					return distance;
				}
				for (int j = 0; j < n; j++) {
					if (!visited[j] && (j != current)) {
						queue.add(j);
						visited[j] = true;
					}
				}
			}
			distance++;
		}
		return Integer.MAX_VALUE; // If facility is not reachable
	}

}
