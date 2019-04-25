package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 * @author heping
 *
 */
public class FourSum {

	public FourSum() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> temp = new HashSet<List<Integer>>();
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums == null || nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		int l = nums.length;
		for(int i = 0; i < l - 3; i ++) {
			for(int j = i + 1; j < l - 2; j++) {
				int sum = target - nums[i] - nums[j];
				int k = j + 1;
				int m = l -1;
				
				while(k < m) {
					if(nums[k] + nums[m] == sum) {
						temp.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
						while((k < m) && (nums[k] == nums[k+1])) k ++;
						while((k < m) && (nums[m] == nums[m-1])) m --;
						k ++;
						m --;
					}else if (nums[k] + nums[m] < sum) {
						k++;
					}else {
						m--;
					}
				}
			}
		}
		for(List<Integer> list : temp) {
			result.add(list);
		}
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		System.out.println(fourSum(nums, 0));
	}
}
