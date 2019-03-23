package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author hp
 *
 */
public class SubSetII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int s=result.size();
            for(int j=0;j<s;j++){
                List<Integer> tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(tmp);
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(result);
        result.clear();
        result.addAll(set);
        return result;
    }
}
