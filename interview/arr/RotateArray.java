package arr;

/*
 Rotate an array two times, for example, { 1, 2, 3, 4, 5 }.
 After two times rotation, it is { 4, 5, 1, 2, 3 }
 * */
public class RotateArray {
	/*
	 * 1. Rotate { 4, 5 }, it is { 1, 2, 3, 5, 4 } 2. Rotate { 1, 2, 3 }, it is
	 * { 3, 2, 1, 5, 4 } 3. Rotate the whole array, it is { 4, 5, 1, 2, 3 }
	 */
	public void rotateArray(int[] A, int times) {
		int n = A.length;
		times %= n;
		rotate(A, n - times, n);
		rotate(A, 0, n - times);
		rotate(A, 0, n);
	}

	private void rotate(int[] A, int start, int end) {
		int mid = (end - start) / 2 + start;
		for (int i = start; i < mid; ++i) {
			swap(A, i, end - 1 - i + start);
		}
	}

	private void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		RotateArray r = new RotateArray();
		r.rotateArray(A, 6);
		for (int i = 0; i < A.length; ++i)
			System.out.println(A[i]);
	}
}
