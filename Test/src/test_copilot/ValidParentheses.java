package test_copilot;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "{[]}";
		System.out.println(isValid(s));
			
	}
	
	// time complexity is O(n) and space complexity is O(n)
	public static boolean isValid(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}

		return stack.isEmpty();

	}
	
	

}
