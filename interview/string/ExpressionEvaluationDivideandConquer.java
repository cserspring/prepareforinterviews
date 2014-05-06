package string;

public class ExpressionEvaluationDivideandConquer {
	public int eval(String expr) {
		expr = expr.replace("\\s+", "");
		String[] operators = { "+", "-", "*", "/" };
		for (int i = 0; i < operators.length; ++i) {
			if (expr.contains(operators[i])) {
				int left = eval(expr.substring(0, expr.indexOf(operators[i])));
				int right = eval(expr.substring(expr.indexOf(operators[i]) + 1));
				int ans = 0;
				switch (operators[i]) {
				case "+":
					ans = left + right;
					break;
				case "-":
					ans = left - right;
					break;
				case "*":
					ans = left * right;
					break;
				case "/":
					ans = left / right;
					break;
				}
				return ans;
			}
		}

		return Integer.parseInt(expr);
	}

	public static void main(String[] args) {
		ExpressionEvaluationDivideandConquer e = new ExpressionEvaluationDivideandConquer();
		System.out.println(e.eval("3/6-1*4+1"));
	}
}
