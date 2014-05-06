package integer;

// Prime is 6k-1 or 6k+1
public class NextPrime {
	public int nextPrime(int n) {
		for (int i = n + 1; i <= Integer.MAX_VALUE; ++i) {
			if (isPrime(i)) {
				return i;
			}
		}
		return -1;
	}

	private boolean isPrime(int n) {
		int limit = (int) Math.sqrt(n);
		for (int i = 2; i <= limit; ++i) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int x = 4;
		NextPrime n = new NextPrime();
		System.out.println(n.nextPrime(x));
	}

}