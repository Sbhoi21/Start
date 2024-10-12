package test_copilot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortArray {

//	static {
//
//		System.out.println("static block");
//		String a = "abc";
//		String c = "abc";
//		if (a == c) {
//			System.out.println("a==b");
//		} else {
//			System.out.println("a!=b");
//		}
//	}
	public record Person(String name, int age) {

	public Person() {
		// TODO Auto-generated constructor stub
		this("dd", 0);  
	}
	public Person(String name, int age) {
		this.age = 0;
		this.name = "";
		// TODO Auto-generated constructor stub
	}
	
	
	}
	// LC. 912 Sort an Array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("main method");
//		int[] nums = { 5, 2, 3, 1 };
//		int[] result = sortArray(nums);
//		for (int i : result) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//
//		int[] result2 = sortArray2(nums);
//		for (int i : result2) {
//			System.out.print(i + " ");
//		}
//		System.out.println();

//		int a = 100;
//		int b = 100;
//		Integer c = new Integer(100);

//		List<String> list = List.of("shubham", "trupti", "sagar");
//
//		list.stream().filter(s -> s.length() < 7).forEach(System.out::println);
//
//		List<String> list2 = Arrays.asList("shubham", "trupti", "sagar");
//		list2.add("ddd");
		
//		List<String> names = Arrays.asList("shubham", "trupti", "sagar");
//		List<String> filteredNames = names.stream().filter(name -> name.length() > 3).collect(Collectors.toList());
//		
//		names.stream().filter(name -> name.length() > 3).toList();
//
//		System.out.println(filteredNames);
//		
//
//		int[] nums = { 5, 2, 3, 1 };
//		
//		List<String> names2 = new ArrayList<>(Arrays.asList("shubham", "trupti", "sagar"));
//		
//		names2.add("dfs");
//		System.out.println(names2);
//		
//		
	

		Person person = new Person("John", 30);
		Person person1 = new Person();
		
		System.out.println(person.name());  // Output: John
		
	}
	


	public static int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	public static void quickSort(int[] nums, int low, int high) {
		if (low < high) {
			int pivot = partition(nums, low, high);
			quickSort(nums, low, pivot - 1);
			quickSort(nums, pivot + 1, high);
		}
	}

	public static int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (nums[j] < pivot) {
				i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, high);
		return i + 1;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// by using map
	public static int[] sortArray2(int[] nums) {
		int[] count = new int[100001];
		for (int num : nums) {
			count[num + 50000]++;
		}
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			while (count[i] > 0) {
				nums[index++] = i - 50000;
				count[i]--;
			}
		}
		return nums;
	}

}
