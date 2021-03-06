package test.hp.leetcode;
/**
 * 152. 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * @author hp
 *
 */
public class MaxProductSubArray {
	public static int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int l = nums.length;
        int[] maxArray = new int[l];
        int[] minArray = new int[l];
        maxArray[0] = nums[0];
        minArray[0] = nums[0];
        int max = nums[0];
        for(int i=1; i<l; i ++) {
            int[] tmp = maxArray;
        	maxArray[i] = Math.max(Math.max(maxArray[i-1] * nums[i], minArray[i-1] * nums[i]), nums[i]);
        	minArray[i] = Math.min(Math.min(tmp[i-1] * nums[i], minArray[i-1] * nums[i]), nums[i]);
        	max = Math.max(maxArray[i],max);
        }
        return max;
    }
	public static void main(String[] args) {
		int[] nums = {2,-1,1,1};
		System.out.println(maxProduct(nums));
	}
}
