package test_copilot;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	// LC. 290 Word Pattern
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));
		
	}
	
	public static boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(words[i])) {
					return false;
				}
			} else {
				if (map.containsValue(words[i])) {
					return false;
				}
				map.put(c, words[i]);
			}
		}
		return true;
	}

}
