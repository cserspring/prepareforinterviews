package sort;

public class QuickSort {
	private int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; ++j) {
			if (arr[j] < pivot)
				swap(arr, ++i, j);
		}
		swap(arr, ++i, end);
		return i;
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pivotLocation = partition(arr, start, end);
			quicksort(arr, start, pivotLocation - 1);
			quicksort(arr, pivotLocation + 1, end);
		}
	}

	public void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] A = { 3, 7, 2, 6, 1, 9, 8, 5, 4, 0 };
		QuickSort q = new QuickSort();
		q.quicksort(A);
		for (int i = 0; i < A.length; ++i)
			System.out.print(A[i] + " ");
	}

}
