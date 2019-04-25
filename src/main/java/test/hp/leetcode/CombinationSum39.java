package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的数字可以无限制重复被选取。

说明：
所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

示例 2:
输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * @author hp
 *
 */
public class CombinationSum39 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        int l = candidates.length;
        if(l == 0) return result;
        Arrays.sort(candidates);
        if(target < candidates[0]) return result;
        
        List<Integer> temp = new ArrayList<Integer>();
        backTrack(candidates, result, temp, target, 0);
        return result;
    }
	
	private static void backTrack(int[] candidates, List<List<Integer>> result, List<Integer> temp, int remain, int start) {
		if(remain < 0) return;
		if(remain == 0) result.add(new ArrayList<Integer>(temp));
		else {
			for(int i=start; i < candidates.length && candidates[i] <= remain; i ++) {
				int curr = candidates[i];
				temp.add(curr);
				backTrack(candidates, result, temp, remain - curr, i);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] newCandidates = {2, 3, 5};
		int target = 8;
		System.out.println(combinationSum(newCandidates, target));
	}
}
