package integer;

public class Sqrt {
	public double sqrt(double x) {
		if (x < 0)
			return -1;
		double precision = 0.000001;
		double start = 0.0;
		double end = x;
		// If x < 1.0, we should set end = 1.0, as 0.1 * 0.1 = 0.01, its square
		// is less than it.
		if (x < 1.0)
			end = 1.0;
		double mid = 0.0;
		while ((end - start) > precision) {
			mid = (end - start) / 2 + start;
			if (mid == x / mid)
				return mid;
			if (mid < x / mid)
				start = mid;
			else
				end = mid;
		}
		return end;
	}

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
		System.out.println(s.sqrt(1));
	}

}
