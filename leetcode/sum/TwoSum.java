package sum;

import java.util.HashMap;

/*
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int[] res = new int[2];
		int n = numbers.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; ++i) {
			int next = target - numbers[i];
			if (map.containsKey(next)) {
				res[0] = map.get(next);
				res[1] = i + 1;
				break;
			} else {
				map.put(numbers[i], i + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7 };
		int target = 10;
		TwoSum t = new TwoSum();
		int[] res = t.twoSum(A, target);
		for (int i = 0; i < res.length; ++i)
			System.out.println(res[i]);
	}
}
