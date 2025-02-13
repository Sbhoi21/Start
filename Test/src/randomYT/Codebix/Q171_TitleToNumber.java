package randomYT.Codebix;

public class Q171_TitleToNumber {

	
	public static void main(String[] args) {
		
		String s = "ZY";
		System.out.println(titleToNumber(s));
		
	}
	
	public static int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = result * 26 + (s.charAt(i) - 'A' + 1);
		}
		return result;
	}
	
	// brute force method
	public static int titleToNumber1(String s) {

		int result = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int val = s.charAt(i) - 'A' + 1;
			result += val * Math.pow(26, n - i - 1);
		}
		return result;
		
	}
		
	
}
