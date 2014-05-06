package string;

import java.lang.Character;

/*
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 click to show clarification.

 Clarification:
 What constitutes a word?
 A sequence of non-space characters constitutes a word.
 Could the input string contain leading or trailing spaces?
 Yes. However, your reversed string should not contain leading or trailing spaces.
 How about multiple spaces between two words?
 Reduce them to a single space in the reversed string.
 * */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String res = "";
		int n = s.length();

		while (true) {
			while (n > 0 && Character.isWhitespace(s.charAt(n - 1)))
				--n;
			if (n == 0)
				break;
			int end = n;
			while (n > 0 && !Character.isWhitespace(s.charAt(n - 1)))
				--n;
			if (!res.isEmpty())
				res += " ";
			res += s.substring(n, end);
		}
		return res;
	}

	public static void main(String[] args) {
		String src = " the blue ";
		ReverseWordsinaString r = new ReverseWordsinaString();
		System.out.println(r.reverseWords(src));
	}
}
