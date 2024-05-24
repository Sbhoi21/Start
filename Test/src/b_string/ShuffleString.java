package b_string;

public class ShuffleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		System.out.println(restoreString(s, indices));
	}

	public static String restoreString(String s, int[] indices) {
		char[] result = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			result[indices[i]] = s.charAt(i);
		}
		return new String(result);
	}

	public static String restoreString1(String s, int[] indices) {
		char[] c = s.toCharArray(); // [c o d e l e e t]
		char[] k = new char[c.length]; // []

		for (int i = 0; i < indices.length; i++) { // i=5 i=4
			k[indices[i]] = c[i]; // k[5]=c[2]=d k[4]=c[0]=c
		}

		String aa = new String(k);

		return aa;
	}
}
