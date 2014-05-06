package permutation;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * */
public class Permutations {
	/*
	 * {1,2,3}, firstly, we get the permutations of {2,3}, namely {2,3},{3,2}
	 * then we insert 1 into {2,3}, we get {1,2,3}, {2,1,3}, {2,3,1}...
	 * */
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		int n = num.length;
		Arrays.sort(num);
		return permute(num, 0, n);
	}

	private ArrayList<ArrayList<Integer>> permute(int[] num, int start, int end) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (start >= end) {
			res.add(new ArrayList<Integer>());
		} else {
			ArrayList<ArrayList<Integer>> partRes = permute(num, start + 1, end);
			int n = partRes.size();
			for (int i = 0; i < n; ++i) {
				ArrayList<Integer> oneResult = partRes.get(i);
				int m = oneResult.size();
				for (int j = 0; j <= m; ++j) {
					ArrayList<Integer> newResult = new ArrayList<Integer>(oneResult);
					newResult.add(j, num[start]);
					res.add(newResult);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] num = { 2, 3, 1 };
		System.out.println(p.permute(num));
	}
}
