package test.hp.leetcode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 * @author heping
 *
 */
public class SearchRange {

	public SearchRange() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length < 1) {
			return new int[] {-1, -1};
		}
        return new SearchRange().search(nums, target, 0, nums.length - 1);
    }
	
	public int[] search(int[] nums, int target, int start, int end) {
		if(nums[start] == target  && nums[end] == target) {
			return new int[] {start, end};
		}
		if(nums[start] <= target && nums[end] >= target) {
			int mid = (start + end)/2;
			int[] left = search(nums, target, start, mid);
			int[] right = search(nums, target, mid + 1, end);
			if(left[0] == -1) return right;
			if(right[0] == -1) return left;
			return new int[] {left[0], right[1]};
		}
		return new int[] {-1, -1};
	}
    
	
}
