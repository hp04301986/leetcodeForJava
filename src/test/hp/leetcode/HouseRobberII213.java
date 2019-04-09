package test.hp.leetcode;
/**
 * 213. 打家劫舍 II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
示例 1:
输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:
输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
 * @author hp
 *
 */
public class HouseRobberII213 {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int l = nums.length;
		if(l == 1) {
			return nums[0];
		}
		if(l == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int[] res1 = new int[l + 1];//0-->n-1
		int[] res2 = new int[l + 1];//1-->n
		res1[1] = nums[0];
		res2[1] = 0;
		for(int i = 2; i < l; i ++) {
			res1[i] = Math.max(res1[i-1], nums[i-1] + res1[i-2]);
		}
		for(int i = 2; i <= l; i ++) {
			res2[i] = Math.max(res2[i-1], nums[i-1] + res2[i-2]);
		}
		return Math.max(res1[l-1], res2[l]);	
	}
}
