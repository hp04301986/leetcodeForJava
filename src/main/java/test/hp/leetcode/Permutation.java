package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 * @author heping
 *
 */
public class Permutation {

	public Permutation() {
		// TODO Auto-generated constructor stub
	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if(tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		}else {
			for(int i=0; i<nums.length; i++) {
				if(tempList.contains(nums[i])) continue;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
