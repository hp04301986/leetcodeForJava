package test.hp.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
(例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2])。
搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
你可以假设数组中不存在重复的元素。
你的算法时间复杂度必须是 O(log n)级别。
示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
 * @author heping
 *
 */
public class SearchIndex {

	public SearchIndex() {
		// TODO Auto-generated constructor stub
	}
	
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
        	int mid = (start + end)/2;
        	int num = nums[mid];
        	//if nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]
        	if((nums[mid] < nums[0]) == (target < nums[0])) {
        		num = nums[mid];
        	}else {
        		num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	}
        	
        	if(num < target) {
        		start = mid + 1;
        	}else if(num > target){
        		end = mid -1;
        	}else {
        		return mid;
        	}
        }
        
        return -1;
    }

}
