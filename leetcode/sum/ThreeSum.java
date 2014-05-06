package sum;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 * */
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		return kSum(num, 0, num.length - 1, 0, 3);
	}

	private ArrayList<ArrayList<Integer>> kSum(int[] num, int start, int end,
			int sum, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (k == 2) {
			// When k==2, we can do it in O(n) time
			while (start < end) {
				if (num[start] + num[end] == sum) {
					ArrayList<Integer> oneResult = new ArrayList<Integer>();
					oneResult.add(num[start++]);
					oneResult.add(num[end--]);
					res.add(oneResult);
					while (start < end && num[start] == num[start - 1])
						++start;
					while (start < end && num[end] == num[end + 1])
						--end;
				} else if (num[start] + num[end] > sum) {
					--end;
				} else {
					++start;
				}
			}
		} else {
			for (int i = end; i >= start + k - 1; --i) {
				// Remove duplicates
				if (i != end && num[i] == num[i + 1])
					continue;
				ArrayList<ArrayList<Integer>> partRes = kSum(num, start, i - 1,
						sum - num[i], k - 1);
				for (int j = 0; j < partRes.size(); ++j) {
					partRes.get(j).add(num[i]);
					res.add(partRes.get(j));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] S = { -1, 0, 1, 2, -1, -1, -4 };
		ThreeSum t = new ThreeSum();
		System.out.println(t.threeSum(S));
	}
}
