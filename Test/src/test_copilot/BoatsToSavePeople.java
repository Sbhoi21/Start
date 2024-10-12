package test_copilot;

import java.util.Arrays;

// LC 881. Boats to Save People
public class BoatsToSavePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] people = { 3, 2, 2, 1 };
		int limit = 3;
		System.out.println(numRescueBoats(people, limit));
		
		// input 2
		int[] people2 = { 3, 5, 3, 4 };
		int limit2 = 5;
		System.out.println(numRescueBoats(people2, limit2));
		
	}
	
	public static int numRescueBoats(int[] people, int limit) {
		int boats = 0;
		int left = 0;
		int right = people.length - 1;
		Arrays.sort(people);
		while (left <= right) {
			if (people[left] + people[right] <= limit) {
				left++;
			}
			right--;
			boats++;
		}
		return boats;
	}
	
}
