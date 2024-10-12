package test_copilot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

	// LC. 49 Group Anagrams
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
		
	}
	
	// time complexity is O(n * klogk) and space complexity is O(n)
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);

			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}

			map.get(key).add(str);
		}

		return new ArrayList<>(map.values());
	}

}
