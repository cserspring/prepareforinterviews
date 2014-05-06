package sort;

/* Every time, we put the largest one at the tail */
public class BubbleSort {
	public void bubbleSort(int[] A) {
		int n = A.length;
		for (int i = n - 2; i >= 0; --i) {
			for (int j = 0; j <= i; ++j) {
				if (A[j] > A[j + 1])
					swap(A, j, j + 1);
			}
		}
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = { 3, 7, 2, 6, 1, 9, 8, 5, 4, 0 };
		BubbleSort b = new BubbleSort();
		b.bubbleSort(A);
		for (int i = 0; i < A.length; ++i)
			System.out.print(A[i] + " ");
	}
}
