package sort;

public class InsertionSort {
	// Just like playing poker
	public void insertionSort(int[] A) {
		int n = A.length;
		for (int i = 1; i < n; ++i) {
			int key = A[i];
			int j = i - 1;
			for (; j >= 0; --j) {
				if (A[j] > key) {
					A[j + 1] = A[j];
				} else {
					break;
				}
			}
			A[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] A = { 3, 4, 2, 6, 9, 1, 5, 7, 8, 0 };
		InsertionSort i = new InsertionSort();
		i.insertionSort(A);
		for (int j = 0; j < A.length; ++j)
			System.out.print(A[j] + " ");
	}

}
