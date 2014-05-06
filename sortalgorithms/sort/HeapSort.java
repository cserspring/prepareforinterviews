package sort;

// This is a max_heap
// In my opinion, Heap actually is not used for sort, it is used to get the K smallest numbers
// Because after sorted, the heap is destroyed.
public class HeapSort {
	public void buildMaxHeap(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; --i) {
			heapify(arr, i, n);
		}
	}

	public void heapSort(int[] arr) {
		int n = arr.length;
		for (int i = n - 1; i > 0; --i) {
			swap(arr, i, 0);
			heapify(arr, 0, i);
		}
	}

	public int[] insert(int[] arr, int key) {
		int n = arr.length;
		int[] res = new int[n + 1];
		res[n] = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i)
			res[i] = arr[i];
		increaseKey(res, n, key);
		return res;
	}

	private void increaseKey(int[] arr, int i, int key) {
		if (arr[i] < key) {
			arr[i] = key;
			int parent = (i - 1) / 2;
			while (parent >= 0 && arr[parent] < arr[i]) {
				swap(arr, parent, i);
				i = parent;
				parent = (i - 1) / 2;
			}
		}
	}

	private void heapify(int[] arr, int i, int n) {
		int child = 2 * i + 1;
		while (child < n) {
			if (child + 1 < n && arr[child] < arr[child + 1])
				child += 1;
			// Only swap with the bigger one
			if (arr[i] > arr[child])
				break;
			swap(arr, i, child);
			i = child;
			child = 2 * child + 1;
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = { 3, 7, 2, 6, 1, 9, 8, 5, 4, 0 };
		HeapSort h = new HeapSort();
		h.buildMaxHeap(A);
		h.heapSort(A);
		for (int i = 0; i < A.length; ++i)
			System.out.print(A[i] + " ");
		System.out.println();

		for (int m = 11; m < 20; ++m) {
			A = h.insert(A, m);
		}
		h.heapSort(A);
		for (int i = 0; i < A.length; ++i)
			System.out.print(A[i] + " ");
		System.out.println();
	}

}
