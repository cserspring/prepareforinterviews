package permutation;

/*
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 ¡ú 1,3,2
 3,2,1 ¡ú 1,2,3
 1,1,5 ¡ú 1,5,1
 * */
public class NextPermutation {
	/*
	 * Find the highest index i such that s{i} < s{i+1}. If no such index
	 * exists, the permutation is the last permutation. Find the highest index 
	 * j > i such that s{j} > s{i}. Such a j must exist, since i+1 is such an
	 * index. Swap s{i} with s{j}. Reverse all the order of all of the elements
	 * after index i
	 */
	public void nextPermutation(int[] num) {
		int first = -1;
		int n = num.length;
		for (int i = 0; i < n - 1; ++i) {
			if (num[i] < num[i + 1]) {
				if (i > first)
					first = i;
			}
		}

		int second = first + 1;
		if (first != -1) {
			for (int i = first + 2; i < n; ++i) {
				if (num[i] > num[first])
					second = i;
			}
			swap(num, first, second);
			reverse(num, first + 1, n-1);
		} else {
			reverse(num, 0, n - 1);
		}

	}

	private void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[j] ^ arr[i];
	}

	private void reverse(int[] arr, int i, int j) {
		for (int k = i; k < i + (j - i + 1) / 2; ++k) {
			swap(arr, k, j - k + i);
		}
	}

	public static void main(String[] args) {
		int[] num = {2,3,1};
		NextPermutation n = new NextPermutation();
		n.nextPermutation(num);
		for (int i = 0; i < num.length; ++i)
			System.out.println(num[i]);
	}
}
