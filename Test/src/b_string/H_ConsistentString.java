package b_string;

public class H_ConsistentString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String allowed = "abc";
		String[] words = { "a", "b", "c", "ab", "ac", "bc", "abc" };
		System.out.println(countConsistentStrings(allowed, words));
		System.out.println(countConsistentStrings1(allowed, words));
	}

	public static int countConsistentStrings(String allowed, String[] words) {
		int count = 0;
		for (String word : words) {
			boolean isConsistent = true;
			for (char c : word.toCharArray()) {
				if (allowed.indexOf(c) == -1) {
					isConsistent = false;
					break;
				}
			}
			if (isConsistent) {
				count++;
			}
		}
		return count;
	}

	// Regular expression
	// worst TC: O(n*m)
	public static int countConsistentStrings1(String allowed, String[] words) {
		int count = 0;
		for (String word : words) {
			if (word.matches("[" + allowed + "]+")) {
				count++;
			}
		}
		return count;
	}

	// TC: O(n+m)
	// SC: O(1)
	public static int countConsistentStrings2(String allowed, String[] words) {
		int count = 0;
		boolean[] allowedChars = new boolean[26];
		for (char c : allowed.toCharArray()) {
			allowedChars[c - 'a'] = true;
		}
		for (String word : words) {
			boolean isConsistent = true;
			for (char c : word.toCharArray()) {
				if (!allowedChars[c - 'a']) {
					isConsistent = false;
					break;
				}
			}
			if (isConsistent) {
				count++;
			}
		}
		return count;
	}

	
	// TC: O(n+m)
	// 100% faster
	public int countConsistentStrings3(String allowed, String[] words) {
		boolean[] bol = new boolean[26];
		for (char c : allowed.toCharArray()) {
			bol[c - 'a'] = true;
		}
		int count = 0;
		for (String s : words) {

			if (find(s, bol)) {
				count++;
			}
		}
		return count;
	}

	private boolean find(String s, boolean[] arr) {
		for (int i = 0; i < s.length(); ++i) {
			if (!arr[s.charAt(i) - 'a']) {
				return false;
			}
		}
		return true;
	}

}
