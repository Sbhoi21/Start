package randomYT.Codebix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q140_WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//		Output: ["cats and dog","cat sand dog"]
//		
//		Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
//		Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//		Explanation: Note that you are allowed to reuse a dictionary word.
//		
//		Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//		Output: []

		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
//		System.out.println(new Q140_WordBreak2().wordBreak(s, wordDict));

		s = "pineapplepenapple";
		wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
//		System.out.println(new Q140_WordBreak2().wordBreak(s, wordDict));
		System.out.println(new Q140_WordBreak2().wordBreak2(s, wordDict));

		s = "catsandog";
		wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
//		System.out.println(new Q140_WordBreak2().wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		Map<String, List<String>> map = new HashMap<>();
		return wordBreak(s, set, map);
	}

	public List<String> wordBreak(String s, Set<String> set, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (set.contains(s)) {
			res.add(s);
		}
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);

			if (set.contains(left)) {
				List<String> right = wordBreak(s.substring(i), set, map);
				for (String r : right) {
					res.add(left + " " + r);
				}
			}
		}
		map.put(s, res);
		return res;
	}

	// optimized solution
	public List<String> wordBreak2(String s, List<String> wordDict) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return res;
		Set<String> set = new HashSet<>(wordDict);
		dfs(s, 0, set, res, new StringBuilder());
		return res;
	}

	public void dfs(String s, int start, Set<String> set, List<String> res, StringBuilder sb) {
//		System.out.println("sb -->" + sb);
//		System.out.println("start -->" + start);
//		System.out.println("s " + s.substring(start));
//		System.out.println();
		if (start == s.length()) {
			res.add(sb.toString().trim());
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String word = s.substring(start, i);
			System.out.println("word -->" + word + "\t i -->" + i + "\t start -->" + start);
			if (set.contains(word)) {
				int len = sb.length();
				sb.append(word).append(" ");
				System.out.println("sb === " + sb);
				System.out.println("i -->" + i + "\t res -->" + res);
				dfs(s, i, set, res, sb);
				sb.setLength(len);
				System.out.println("sb after ==== " + sb);
			}
		}
	}

}
