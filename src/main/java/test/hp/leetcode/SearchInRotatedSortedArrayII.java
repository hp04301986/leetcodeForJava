package test.hp.leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
You are given a target value to search. If found in the array return true, otherwise return false.
Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 * @author hp
 *
 */
public class SearchInRotatedSortedArrayII {
	public static boolean search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		if(right == -1) return false;
		if(right == 0) {
			if(nums[0] == target)return true;
			else return false;
		}
		while(left < right) {
			int mid = (left + right) / 2;
			if(nums[left]==target) return true;
			if(nums[right] == target) return true;
			if(nums[mid] == target) return true;
			if(nums[left] < nums[mid]) {//left part sorted
				if((target > nums[left]) && (target < nums[mid])) right = mid;
				else left = mid + 1;
			}else if(nums[mid] < nums[right]) {// right part sorted
				if((target > nums[mid])&& (target < nums[right])) left = mid + 1;
				else right = mid;
			}else left ++;
		}
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 3, 1};
		System.out.println(search(nums, 3));
	}
}
