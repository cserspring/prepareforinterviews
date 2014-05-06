package array;
/*
 There are two sorted arrays A and B of size m and n respectively. 
 Find the median of the two sorted arrays. The overall run time complexity 
 should be O(log (m+n)).
 * */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if (((m + n) & 0x1) == 0)
			return (double) (median(A, B, 0, m, 0, n, (m + n) / 2 + 1) + 
					median(A, B, 0, m, 0, n, (m + n) / 2)) / 2;
		return median(A, B, 0, m, 0, n, (m + n) / 2 + 1);
	}

	private int median(int[] A, int[] B, int astart, int aend, int bstart,
			int bend, int k) {
		int m = aend - astart;
		int n = bend - bstart;
		if (m > n)
			return median(B, A, bstart, bend, astart, aend, k);
		if (aend <= astart)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[astart], B[bstart]);
		int pa = Math.min(m, k / 2);
		int pb = k - pa;
		if (A[astart + pa - 1] < B[bstart + pb - 1])
			return median(A, B, astart + pa, aend, bstart, bend, k - pa);
		if (A[astart + pa - 1] > B[bstart + pb - 1])
			return median(A, B, astart, aend, bstart + pb, bend, k - pb);
		return A[astart + pa - 1];
	}

	public static void main(String[] args) {
		MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
		int[] B = { 1 };
		int[] A = { 2, 3 };
		System.out.println(m.findMedianSortedArrays(A, B));
	}

}
