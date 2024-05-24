package b_string;

public class GoalParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String command = "G()()()()(al)";
		System.out.println(interpret(command));
		System.out.println(new GoalParser().interpret1(command));

	}

	public static String interpret(String command) {
		return command.replace("()", "o").replace("(al)", "al");
	}

	public String interpret1(String command) {
		StringBuilder result = new StringBuilder();
		int i = 0;
		while (i < command.length()) {
			if (command.charAt(i) == 'G') {
				result.append('G');
				i++;
			} else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
				result.append('o');
				i += 2;
			} else if (command.charAt(i) == '(' && command.charAt(i + 1) == 'a' && command.charAt(i + 2) == 'l'
					&& command.charAt(i + 3) == ')') {
				result.append("al");
				i += 4;
			}
		}
		return result.toString();
	}
}
