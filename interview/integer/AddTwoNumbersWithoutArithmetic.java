package integer;

/* Add two numbers without + - * / arithmetics */
public class AddTwoNumbersWithoutArithmetic {
	public int addTwoNumbers(int a, int b) {
		if (b == 0)
			return a;
		int sum = a ^ b;
		int carry = (a & b) << 1;
		return addTwoNumbers(sum, carry);
	}

	public static void main(String[] args) {
		AddTwoNumbersWithoutArithmetic a = new AddTwoNumbersWithoutArithmetic();
		System.out.println(a.addTwoNumbers(-20, -2));
	}
}
