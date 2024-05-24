package b_string;

public class FinalValueOperarion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] operations = { "++X", "X++", "--X" };
		System.out.println(finalValueAfterOperations(operations));
	}

	public static int finalValueAfterOperations(String[] operations) {

		int x = 0;
		for (String operation : operations) {
			if (operation.contains("++")) {
				x++;
			} else {
				x--;
			}
		}
		return x;
	}

	public static int finalValueAfterOperations1(String[] operations) {
		int x = 0;
		for (String o : operations)
			x += (44 - o.charAt(1));
		return x;
	}

}
