package test.hp.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。
示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author hp
 *
 */
public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<Integer>());
		for(int num : nums) {
			int s = result.size();
			for(int i=0; i < s; i++) {
				List<Integer> tmp1= new ArrayList<Integer>(result.get(i));
				tmp1.add(num);
				result.add(tmp1);
			}
		}
		return result;
    }
	
	public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for(int num: nums){
        	int s = result.size();
            for(int i=0; i< s; i++){
                List<Integer> list = new ArrayList<Integer>(result.get(i));
                list.add(num);
                result.add(list);
            }        
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = subsets1(nums);
		for(List<Integer> e: result) {
			System.out.println(e.toString());
		}
	}
}
