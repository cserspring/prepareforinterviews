package permutation;

/*
 The set [1,2,3,бн,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 * */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		int[] arr = new int[n];
		int nfact = 1;
		for (int i = 1; i <= n; ++i) {
			arr[i - 1] = i;
			nfact *= i;
		}
		--k;
		StringBuilder sb = new StringBuilder();
		for (int i = n; i >= 1; --i) {
			nfact = nfact / i;
			int index = k / nfact;
			k = k % nfact;
			sb.append(arr[index]);
			for (int j = index; j < n - 1; ++j)
				arr[j] = arr[j + 1];
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 1));
	}
}
