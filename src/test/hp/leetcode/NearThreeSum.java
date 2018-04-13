package test.hp.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 S，找出 S 中的三个整数使得他们的和与给定的数 target 最接近。返回这三个数的和。假定每组输入只存在一个答案。
例如，给定数组 S = {-1 2 1 -4}, 并且 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 * @author heping
 *
 */
public class NearThreeSum {

	public NearThreeSum() {
		// TODO Auto-generated constructor stub
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int cap = 999999999;
        Arrays.sort(nums);
        int l = nums.length;
        for(int i=0; i<l; i++) {
        	int sum = target - nums[i];
        	int j = i+1;
        	int k = l-1;
        	while(j < k) {
        		if(nums[j] + nums[k] == sum) {
        			return target;
        		}else if(nums[j] + nums[k] < sum) {
        			if(Math.abs(cap) > Math.abs(sum - nums[j] - nums[k])) {
        				cap = sum - nums[j] - nums[k];
        				result = nums[i]+ nums[j]+nums[k];
        			}
        			j++;
        		}else if(nums[j] + nums[k] > sum) {
        			if(Math.abs(cap) > Math.abs(sum - nums[j] - nums[k])) {
        				cap = sum - nums[j] - nums[k];
        				result = nums[i]+ nums[j]+nums[k];
        			}
        			k--;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(nums, 1));
	}
}
