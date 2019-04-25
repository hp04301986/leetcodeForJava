package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
Example
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author hp
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if((n < 1) || (k < 1) || (n < k)) {
			return result;
		}
		backtrack(result, new ArrayList<Integer>(), n, k, 1);
		return result;
    }
	
	private void backtrack(List<List<Integer>> result, List<Integer> temp, int n, int k, int c) {
		if(k == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if ((c > n) || (k < 0)) {
			return;
		}
		for(int i=c; i <= n; i ++) {
			temp.add(i);
			backtrack(result, temp, n, k-1, i+1);
			temp.remove(temp.size() - 1);
		}
	}
}
