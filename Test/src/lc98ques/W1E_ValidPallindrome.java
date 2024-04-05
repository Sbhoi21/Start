package lc98ques;

public class W1E_ValidPallindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {

		int i = 0, t = s.length() - 1;

		while (i < t) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(t);
			if (!(Character.isLetterOrDigit(c1))) {
				i++;
				continue;
			}
			if (!Character.isLetterOrDigit(c2)) {
				t--;
				continue;
			}

			if (Character.toUpperCase(s.charAt(i)) == Character.toUpperCase(s.charAt(t))) {
				i++;
				t--;
			} else {
				return false;
			}
		}

		return true;
	}

}
