package integer;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 click to show spoilers.

 Have you thought about this?
 Here are some good questions to ask before coding. Bonus points for you if you have 
 already thought through this!

 If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

 Did you notice that the reversed integer might overflow? Assume the input is a 32-bit 
 integer, then the reverse of 1000000003 overflows. How should you handle such cases?

 Throw an exception? Good, but what if throwing an exception is not an option? You would 
 then have to re-design the function (ie, add an extra parameter).
 * */
public class ReverseInteger {
	public int reverse(int x) {
		int res = 0;
		while (x != 0) {
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return res;
	}

	public int reverseII(int x) {
		boolean negative = x < 0 ? true : false;
		int src = Math.abs(x);
		int res = 0;
		while (src > 0) {
			int rem = src % 10; // Actually, we don't need this variable
			src = src / 10;
			res = res * 10 + rem;
		}
		return negative ? -res : res;
	}

	public static void main(String[] args) {
		int x = -10;
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(x));
	}

}
