package string;

import java.util.Stack;

/*
 Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		int n = tokens.length;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; ++i) {
			if (tokens[i].matches("[+-]?\\d+")) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				int a = stack.pop();
				int b = stack.pop();
				int ans = 0;
				// This is only permitted in Java 1.7
				switch (tokens[i]) {
				case "+":
					ans = b + a;
					break;
				case "-":
					ans = b - a;
					break;
				case "*":
					ans = b * a;
					break;
				case "/":
					ans = b / a;
					break;
				}
				stack.push(ans);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		System.out.println(e.evalRPN(tokens));
	}

}
