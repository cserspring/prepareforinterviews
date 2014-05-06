package sum;

import java.util.Arrays;

/*
 Given an array S of n integers, find three integers in S such that the sum 
 is closest to a given number, target. Return the sum of the three integers. 
 You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
public class ThreeSumClosest {
	/*
	 * Sort the array first. Keep one element, and then use start and end to
	 * find the remaining part.
	 */
	public int threeSumClosest(int[] num, int target) {
		int n = num.length;
		Arrays.sort(num);
		int sum = num[0] + num[1] + num[n - 1];
		int res = sum;
		for (int i = 0; i < n - 2; ++i) {
			// Remove duplicates
			if (i != 0 && num[i] == num[i - 1])
				continue;
			int start = i + 1;
			int end = n - 1;
			// Use start and end pointer
			while (start < end) {
				sum = num[i] + num[start] + num[end];
				if (Math.abs(target - sum) < Math.abs(target - res))
					res = sum;

				if (sum == target)
					return sum;

				if (sum < target)
					start++;
				else
					end--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] S = { -1, 2, 1, -4 };
		ThreeSumClosest t = new ThreeSumClosest();
		System.out.println(t.threeSumClosest(S, 1));
	}
}
