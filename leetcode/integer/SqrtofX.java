package integer;

/*
 Implement int sqrt(int x).
 Compute and return the square root of x.
 * */
public class SqrtofX {
	public int sqrt(int x) {
		if (x < 0)
			return -1;
		if (x == 0 || x == 1)
			return x;
		int start = 0;
		int end = x;
		int mid = 0;
		// Be careful here, mid * mid may be overflowed, so we use
		// mid to compare with x/mid
		while (start <= end) {
			mid = (end - start) / 2 + start;
			// int res = mid * mid;
			if (mid == x / mid)
				return mid;
			if (mid < x / mid)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return end;
	}

	public static void main(String[] args) {
		SqrtofX s = new SqrtofX();
		System.out.println(s.sqrt(15));
	}

}
