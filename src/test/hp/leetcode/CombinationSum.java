package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
 * @author heping
 *
 */
public class CombinationSum {

	public CombinationSum() {
		// TODO Auto-generated constructor stub
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else {
			for(int i = start; i < nums.length; i ++) {
				tempList.add(nums[i]);
				System.out.println(tempList);
				backtrack(list, tempList, nums, remain-nums[i], i);
				tempList.remove(tempList.size()-1);
			}
		}
	}

}
