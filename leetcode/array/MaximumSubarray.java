package array;

/*
 Find the contiguous subarray within an array (containing at least one number) 
 which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using 
 the divide and conquer approach, which is more subtle.
 * */
public class MaximumSubarray {
	// Assumption: at least one number
	// Three solutions
	public int maxSubArray(int[] A) {
		int n = A.length;
		int left = A[0];
		int max = A[0];
		for (int i = 1; i < n; ++i) {
			if (left < 0)
				left = A[i];
			else
				left = left + A[i];
			max = Math.max(max, left);
		}
		return max;
	}

	public int maxSubArrayII(int[] A) {
		int n = A.length;
		int left = A[0];
		int max = A[0];
		for (int i = 1; i < n; ++i) {
			if (left >= 0 && left + A[i] >= 0)
				left = left + A[i];
			else
				left = A[i];
			max = Math.max(max, left);
		}
		return max;
	}

	public static int maxSubArrayIII(int[] A) {
		int n = A.length;
		int max = A[0];
		int left = 0;

		for (int i = 0; i < n; ++i) {
			left = Math.max(left + A[i], A[i]);
			max = Math.max(max, left);
		}
		return max;
	}

	public static void main(String args[]) {
		MaximumSubarray m = new MaximumSubarray();
		int[] A = { 4, -3, 6 };
		System.out.println(m.maxSubArray(A));
	}
}
