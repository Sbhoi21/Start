package lc98ques;

import java.util.Arrays;

public class W1G_ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given two strings s and t, return true if t is an anagram of s, and false otherwise.//
//		An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//		Example 1:
//		Input: s = "anagram", t = "nagaram"
//		Output: true

//		Example 2:
//		Input: s = "rat", t = "car"
//		Output: false

		String s = "anagram", t = "nagaram";
		System.out.println(isAnagram(s, t));

	}

	public static boolean isAnagram1(String s, String t) {

		char[] c1 = s.toCharArray();
		Arrays.sort(c1);
		char[] c2 = t.toCharArray();
		Arrays.sort(c2);
		System.out.println(new String(c1));

		return Arrays.equals(c1, c2);
	}

	public static boolean isAnagram(String s, String t) {

		int[] count = new int[26];

		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			count[c - 'a']--;
		}

		for (int c : count) {
			if (c != 0) {
				return false;
			}
		}

		return true;
	}

}
