package permutation;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 * */
public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
					if (j != 0 && num[start] == oneResult.get(j - 1))
						break;
					ArrayList<Integer> newResult = new ArrayList<Integer>(oneResult);
					newResult.add(j, num[start]);
					res.add(newResult);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int[] num = { 2, 2, 2, 3 };
		System.out.println(p.permuteUnique(num));
	}

}
