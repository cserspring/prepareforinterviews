package integer;

/*
 Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegertoRoman {
	public String intToRoman(int num) {
		int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbol = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		String res = "";
		for (int i = 0; i < nums.length; ++i) {
			int times = num / nums[i];
			num = num % nums[i];
			for (; times > 0; --times)
				res += symbol[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int num = 900;
		IntegertoRoman i = new IntegertoRoman();
		System.out.println(i.intToRoman(num));
	}

}
