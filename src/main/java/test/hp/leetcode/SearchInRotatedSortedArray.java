package test.hp.leetcode;
/**
 * 33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 * @author hp
 *
 */
public class SearchInRotatedSortedArray {
	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		if(right == 0) return -1;
		else if(right == 1) {
			if(nums[right-1] == target) return 0;
			else return -1;
		}
        if(nums[0] == target) return 0;
        if(nums[right -1] == target) return right - 1;
		while(left < right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            if(((nums[mid] - nums[0]) * (target - nums[0])) > 0){//on the same side
            	System.out.println("on the same side");
                if(target > nums[mid]) left = mid + 1;
                else right = mid;
            }else if((target < nums[0])) {
            	System.out.println("on the right side");
            	left = mid + 1; // on the right side
            }
            else {
            	System.out.println("on the left side");
            	right = mid; // on the left side
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(search(nums, 0));
	}
}
