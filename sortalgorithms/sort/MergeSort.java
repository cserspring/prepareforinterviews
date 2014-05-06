package sort;

public class MergeSort {
	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (end - start) / 2 + start;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end) {
		int p = mid - start + 1;
		int q = end - mid;
		int[] left = new int[p];
		int[] right = new int[q];
		for (int i = 0; i < p; ++i) {
			left[i] = arr[start + i];
		}
		for (int i = 0; i < q; ++i) {
			right[i] = arr[mid + 1 + i];
		}
		while (true) {
			if (p > 0 && q > 0)
				arr[end--] = (left[p - 1] > right[q - 1] ? left[--p]
						: right[--q]);
			else if (p > 0)
				arr[end--] = left[--p];
			else if (q > 0)
				arr[end--] = right[--q];
			else
				break;
		}
		// If it is in C/C++, remember to free left[] and right[]
	}

	public static void main(String[] args) {
		int[] A = { 3, 7, 2, 6, 1, 9, 8, 5, 4, 0 };
		MergeSort m = new MergeSort();
		m.mergeSort(A);
		for (int i = 0; i < A.length; ++i)
			System.out.print(A[i] + " ");
	}

}
