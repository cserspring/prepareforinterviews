package integer;

public class AddTwoLargeNumbers {
	public String addTwoNumbers(String a, String b) {
		if (a.startsWith("-") && b.startsWith("-")) {
			return "-" + addTwoPositive(a.substring(1), b.substring(1));
		} else if (a.startsWith("-")) {
			return subtract(b, a.substring(1));
		} else if (b.startsWith("-")) {
			return subtract(a, b.substring(1));
		} else {
			return addTwoPositive(a, b);
		}
	}

	public void test(String a, String b, String res) {
		String c = addTwoNumbers(a, b);
		if (c.equals(res))
			System.out.println(true);
		else
			System.out.println(false);
	}

	private String addTwoPositive(String a, String b) {
		int alen = a.length();
		int blen = b.length();
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (alen > 0 || blen > 0) {
			int sum = carry;
			int num1 = 0;
			int num2 = 0;
			if (alen > 0)
				num1 = a.charAt(--alen) - '0';
			if (blen > 0)
				num2 = b.charAt(--blen) - '0';
			sum += num1 + num2;
			carry = sum / 10;
			sb.insert(0, (char) (sum % 10 + '0'));
		}
		if (carry != 0)
			sb.insert(0, (char) (carry + '0'));

		return sb.toString();
	}

	private String subtract(String a, String b) {
		if (!isLargerOrEqual(a, b))
			return "-" + subtract(b, a);
		int alen = a.length();
		int blen = b.length();
		StringBuilder sb = new StringBuilder();
		int getFromPrev = 0;
		while (alen > 0 || blen > 0) {
			int sum = 0;
			int num1 = 0 - getFromPrev;
			int num2 = 0;
			if (alen > 0)
				num1 += a.charAt(--alen) - '0';
			if (blen > 0)
				num2 = b.charAt(--blen) - '0';
			if (num1 < num2) {
				getFromPrev = 1;
				sum = 10 + num1 - num2;
			} else {
				getFromPrev = 0;
				sum = num1 - num2;
			}
			sb.insert(0, (char) (sum + '0'));
		}
		String res = sb.toString();
		int reslen = res.length();
		int i = 0;
		while (i < reslen - 1 && res.charAt(i) == '0')
			i++;
		res = res.substring(i);
		if (getFromPrev != 0)
			res = "-" + res;
		return res;
	}

	private boolean isLargerOrEqual(String a, String b) {
		if (a.equals(b))
			return true;
		int alen = a.length();
		int blen = b.length();
		if (alen > blen)
			return true;
		if (alen < blen)
			return false;
		if (a.charAt(0) > b.charAt(0))
			return true;
		if (a.charAt(0) < b.charAt(0))
			return false;
		return isLargerOrEqual(a.substring(1), b.substring(1));
	}

	public static void main(String[] args) {
		AddTwoLargeNumbers a = new AddTwoLargeNumbers();
		a.test("-123", "22", "-101");
		a.test("0", "0", "0");
		a.test("9999999999", "9999999999", "19999999998");
		a.test("-9999999999", "9999999999", "0");
		a.test("-9999999999", "-9999999999", "-19999999998");
	}

}
