import java.util.*;

public class ProductSumExpression {	
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public double evaluate(String expr) {	
		Stack<Integer> stack = new Stack<Integer>();
		for (int i=0;i<expr.length();++i) {
			if (expr.charAt(i) == '(') {
				stack.push(i);
			} else if (expr.charAt(i) == ')') {
				map.put(stack.pop(), i);
			}
		}
		return parse(expr,0,expr.length()-1);		
	}
	
	private double parse(String expr, int start, int end) {
		// System.out.println("current expr: " + expr.substring(start,end+1));
		if (expr.charAt(start) == '(') return parse(expr, start+1,end-1);
		if (isLetter(expr.charAt(start))) {
			int i=start + 1;
			while (i<=end && isLetter(expr.charAt(i))) ++i;
			String op = expr.substring(start, i);
			int right = this.map.get(i);
			Stack<Double> stack = new Stack<Double>();
			int subStart = ++i;
			
			while (i<right) {
				if (expr.charAt(i)=='(') {
					int subEnd = map.get(i);
					i=++subEnd;
				// Get the intermediate part which is before ","
				} else if (expr.charAt(i) ==','){
					double t = parse(expr,subStart,i-1);
					// System.out.println("before , " + t);
					stack.push(t);
					subStart=++i;
				}else {
					++i;
				}
				
				// Do not miss the last part
				if (i==right) {
					double t = parse(expr,subStart,i-1);
					// System.out.println("last " + t);
					stack.push(t);
				}
			}
			if (op.equals("product")) {
				double r=1.0;
				while(!stack.isEmpty()) r=r*stack.pop();
				return r;
			} 
			double sum=0.0;
			while(!stack.isEmpty()) sum=sum+stack.pop();
			return sum;
		} else {
			int i=start+1;
			while (i<=end && isNumber(expr.charAt(i))) ++i;
			double d = Double.parseDouble(expr.substring(start,i));
			return d;
		}
	}
	
	private boolean isLetter(char c) {
		return c>='a' && c<='z';
	}
	
	private boolean isNumber(char c) {
		return c=='-' || c=='+' || c=='.' || (c>='0' && c<='9');
	}
	
	public static void main(String[] args) {
		ProductSumExpression pse = new ProductSumExpression();
		double s=pse.evaluate("product(sum(-1.5,2),2,sum(1.5,2))");
		System.out.println(s);
		s=pse.evaluate("product(product(-1.5,2),2,sum(1.5,2))");
		System.out.println(s);
		s=pse.evaluate("sum(product(-1.5,2),2,product(1.5,2))");
		System.out.println(s);
	}

}
