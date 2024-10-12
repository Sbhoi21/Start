package test_copilot;

public class LongestPrefeix {
	
//	LC. 14 Longest Common Prefix
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"flow","flower","flight"};
		System.out.println(longestCommonPrefix(strs));
	}

	// time complexity is O(n) and space complexity is O(1)
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}

		String prefix = strs[0];
		System.out.println(prefix);
		for (int i = 1; i < strs.length; i++) {
			System.out.println("index   " + strs[i].indexOf(prefix));
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				System.out.println("prefix   " + prefix);
			}
		}

		return prefix;
	}
}
