package string;

/*
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, 
 please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 You are responsible to gather all the input requirements up front.

 Requirements for atoi:
 The function first discards as many whitespace characters as necessary until the first 
 non-whitespace character is found. Then, starting from this character, takes an optional 
 initial plus or minus sign followed by as many numerical digits as possible, and interprets 
 them as a numerical value.

 The string can contain additional characters after those that form the integral number, 
 which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, 
 or if no such sequence exists because either str is empty or it contains only whitespace 
 characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is 
 out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * */
public class StringtoInteger {
	public int atoi(String str) {
		int INT_MAX = 2147483647;
		int INT_MIN = -2147483648;
		int n = str.length();
		int i = 0;
		while (i < n && Character.isWhitespace(str.charAt(i)))
			++i;
		boolean positive = true;
		if (i < n && str.charAt(i) == '-') {
			positive = false;
			++i;
		} else if (i < n && str.charAt(i) == '+') {
			++i;
		}
		int res = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int left = res * 10;
			// Check overflow
			if (res != 0 && left / res != 10)
				return positive ? INT_MAX : INT_MIN;

			int right = str.charAt(i) - '0';
			res = left + right;
			// Check overflow
			if (res < left)
				return positive ? INT_MAX : INT_MIN;
			++i;
		}
		return positive ? res : -res;
	}

	public static void main(String[] args) {
		StringtoInteger s = new StringtoInteger();
		String str = "   -45gjgj7";
		System.out.println(s.atoi(str));
	}
}
