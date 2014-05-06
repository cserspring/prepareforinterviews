package string;

import java.util.HashMap;
import java.util.Stack;

/*
 Expression = Term + Expression | Term - Expression | Term
 Term = Factor * Term | Factor / Term | Factor
 Factor = (Expression) | Decimal
 * */
public class ExpressionEvaluation {
	// Operator and its priority
	private HashMap<Character, Integer> map;

	public int eval(String expr) {
		map = new HashMap<Character, Integer>();
		map.put('(', 1);
		map.put('*', 3);
		map.put('/', 3);
		map.put('+', 2);
		map.put('-', 2);
		map.put(')', 1);
		String postfix = toPostfix(expr);
		return evalPostfix(postfix);
	}

	private String toPostfix(String expr) {
		expr = expr.trim().replaceAll("\\s+", "");
		String postfix = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expr.length(); ++i) {
			char c = expr.charAt(i);
			if (c == '-' && (i == 0 || !Character.isDigit(expr.charAt(i - 1)))) {
				postfix += c;
				continue;
			}

			if (Character.isDigit(c)) {
				postfix += c;
				if (i == expr.length() - 1
						|| !Character.isDigit(expr.charAt(i + 1)))
					postfix += " ";
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix += stack.pop() + " ";
				}
				stack.pop();
			} else if (c == '(' || stack.isEmpty()
					|| map.get(c) > map.get(stack.peek())) {
				stack.push(c);
			} else if (map.get(c) <= map.get(stack.peek())) {
				while (!stack.isEmpty() && map.get(c) <= map.get(stack.peek()))
					postfix += stack.pop() + " ";
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop() + " ";
		}
		return postfix;
	}

	private int evalPostfix(String postfix) {
		String[] tokens = postfix.trim().split("\\s+");

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

	public static void main(String args[]) {
		ExpressionEvaluation s = new ExpressionEvaluation();
		System.out.println(s.eval("-8 +6*(7-1) + (7-2)/(5 - 0)"));
	}
}
