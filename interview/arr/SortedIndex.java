package arr;

import java.util.Arrays;
import java.util.Comparator;

/*
 Output the original index after the array is sorted.
 For example, the original array is {1,3,2,5,4}
 After sorted, output the original index, namely {0,2,1,4,3}
 * */
public class SortedIndex implements Comparator<Integer> {
	private int[] arr;

	public Integer[] originalIndex(int[] A) {
		this.arr = A;
		Integer[] res = new Integer[A.length];
		for (int i = 0; i < A.length; ++i)
			res[i] = i;
		Arrays.sort(res, this);
		return res;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return arr[o1] - arr[o2];
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 2, 5, 4 };
		SortedIndex s = new SortedIndex();
		Integer[] res = s.originalIndex(A);
		for (int i = 0; i < res.length; ++i)
			System.out.println(res[i]);
	}
}
