package randomYT.Codebix;

public class Q520_DetectCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "USA";
		System.out.println(new Q520_DetectCapital().detectCapitalUse(word));
		System.out.println(new Q520_DetectCapital().detectCapitalUse2(word));

		word = "FlaG";
		System.out.println(new Q520_DetectCapital().detectCapitalUse(word));
		System.out.println(new Q520_DetectCapital().detectCapitalUse2(word));

		word = "FaceBook";
		System.out.println(new Q520_DetectCapital().detectCapitalUse(word));
		System.out.println(new Q520_DetectCapital().detectCapitalUse2(word));

	}

	public boolean detectCapitalUse(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		int count = 0;
		for (char c : word.toCharArray()) {
			if (Character.isUpperCase(c)) {
				count++;
			}
		}
		return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
	}

	// optmise
	public boolean detectCapitalUse2(String word) {
		if (word == null || word.length() <= 1) {
			return true;
		}
		int left = 1;
		int right = word.length() - 1;
		var isUpperCase = Character.isUpperCase(word.charAt(1));
		if (isUpperCase && Character.isUpperCase(word.charAt(0)) == false) {
			return false;
		}
		while (left <= right) {
			if (isUpperCase != Character.isUpperCase(word.charAt(left))
					|| isUpperCase != Character.isUpperCase(word.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
//		return isUpperCase ? Character.isUpperCase(word.charAt(0)) : true;
	}

}
