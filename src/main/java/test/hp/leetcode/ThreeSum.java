package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。
注意：结果不能包括重复的三个数的组合。
例如, 给定数组 S = [-1, 0, 1, 2, -1, -4]，
一个结果集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * @author heping
 *
 */
public class ThreeSum {

	public ThreeSum() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3) {
			return result;
		}
		Arrays.sort(nums);
		for(int i = 0; i <nums.length-2; i ++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int sum = 0 - nums[i];
				int j = i + 1;
				int k = nums.length - 1;
				while(j < k) {
					if(nums[j] + nums[k] == sum) {
						result.add(Arrays.asList(nums[i], nums[j], nums[k]));
	    				while(j < k && nums[j] == nums[j + 1]) j++;
	    				while(j < k && nums[k] == nums[k -1]) k--;
	    				j++;
	    				k--;
					}else if(nums[j] + nums[k] < sum) {
						j++;
					}else {
						k--;
					}
				}
			}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threeSum(nums);
		for(List<Integer> r : result) {
			System.out.println("+++++++++++++++");
			for(Integer rr : r) {
				System.out.println(rr);
			}
		}
	}
}
