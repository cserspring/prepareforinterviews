package integer;

/*
 Divide two integers without using multiplication, division and mod operator.
 * */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		// Use long to save dividend and divisor
		// In abs function, we need to use long converter, or a is still negative.
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int res = 0;
		long rem = a;
		while (b <= rem) {
			for (long i = b, j = 0; i <= rem; i = i << 1, ++j) {
				rem -= i;
				res += 1 << j;
			}
		}
		return (((divisor ^ dividend) >> 31) == 0) ? res : -res;
	}

	public static void main(String args[]) {
		DivideTwoIntegers d = new DivideTwoIntegers();
		System.out.println(d.divide(-2147483648, 1));
	}
}
