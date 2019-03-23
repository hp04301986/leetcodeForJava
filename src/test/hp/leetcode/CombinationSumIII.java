package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。 

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]

示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 * @author hp
 *
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> tmp = new ArrayList<Integer>();
		if(k == 1 && n <= 9) {
			tmp.add(n);
			result.add(new ArrayList<>(tmp));
			return result;
		}
		backTrack(result, tmp, k, n, 1);
		return result;
    }
	private void backTrack(List<List<Integer>> result, List<Integer> tmp, int left, int remain, int index) {
		if(left < 0 || remain < 0) return;
		if(left == 0 && remain == 0) {
			result.add(new ArrayList<>(tmp));
		}
		for(int i = index; i <= 9; i ++) {
			tmp.add(i);
			backTrack(result, tmp, left - 1, remain - i, i+1);
			tmp.remove(tmp.size() - 1);
		}
	}
	public static void main(String[] args) {
		System.out.println(new CombinationSumIII().combinationSum3(3, 9));
	}
}
