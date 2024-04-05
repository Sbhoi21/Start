package basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

	public static String getLargestNumber(List<Integer> array) {
		// Sort the array in descending order.
		Collections.sort(array, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));

		// Convert the array to a string.
		String largestNumber = "";
		for (int i = 0; i < array.size(); i++) {
			largestNumber += String.valueOf(array.get(i));
		}

		return largestNumber;
	}

	public static String getLargestNumber1(List<Integer> array) {
		// Sort the array in descending order.
		Collections.sort(array, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));

		return array.stream().map(Object::toString).collect(Collectors.joining(""));
	}

	public static void main(String[] args) {
		List<Integer> array = Arrays.asList(1, 36, 3, 98, 9, 76, 45, 4);
		String largestNumber = getLargestNumber(array);
		System.out.println("The largest number is " + largestNumber);
	}
}