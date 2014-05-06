package search;

public class QuickSelect {
	public int quickSelect(int[] A, int k) {
		int start = 0;
		int end = A.length - 1;
		int i = -1;
		while (start <= end) {
			i = partition(A, start, end);
			if (i == k - 1)
				return A[i];
			if (i < k - 1)
				start = i + 1;
			else
				end = i - 1;
		}
		return -1;
	}

	private int partition(int[] A, int start, int end) {
		int pivot = A[end];
		int i = start - 1;
		for (int j = start; j < end; ++j) {
			if (A[j] < pivot)
				swap(A, ++i, j);
		}
		swap(A, ++i, end);
		return i;
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		QuickSelect q = new QuickSelect();
		int[] A = { 3, 4, 2, 6, 9, 1, 5, 7, 8, 0 };
		System.out.println(q.quickSelect(A, 3));
	}

}
