package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 * @author heping
 *
 */
public class CombinationSum2 {

	public CombinationSum2() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
	
	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else {
			for(int i=start; i< nums.length; i ++) {
				if((i>start) && (nums[i] == nums[i-1])) continue;//skip duplicates
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain-nums[i], i+1);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(a, 8));
	}

}
