package b_string;

public class MaxWordsFound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] text = { "Bob hit a ball, the hit BALL flew far after it was hit.", "hit" };
//		String[] text={"alice and bob love leetcode","i think so too","this is great thanks very much"};
		System.out.println(mostWordsFound(text));
	}

	public static int mostWordsFound(String[] text) {

		int maxWords = 0;
		int count = 0;
		for (String t : text) {
			count = t.trim().split(" ").length;
//			count = wordcount(t);
			maxWords = Math.max(maxWords, count);
		}
		return maxWords;
	}

	public static int wordcount(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {

			if (c == ' ') {
				count++;
			}
		}
		return count + 1;
	}

}
