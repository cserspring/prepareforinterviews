package integer;

import java.util.HashMap;

/*
 Given a roman numeral, convert it to an integer.
 Input is guaranteed to be within the range from 1 to 3999.
 * */
public class RomantoInteger {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int n = s.length();
		int res = 0;
		for (int i = n - 1; i >= 0; --i) {
			if (i != n - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
				res -= map.get(s.charAt(i));
			else
				res += map.get(s.charAt(i));
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "MCMXCVI";
		RomantoInteger r = new RomantoInteger();
		System.out.println(r.romanToInt(s));
	}

}
