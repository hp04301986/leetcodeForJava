package test.hp.search;

import java.util.Arrays;

public class BinarySearch {
	
	public int binarySearch(int[] nums, int target) {
		Arrays.sort(nums);
		if(nums == null || nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) return mid;
			if(nums[mid] > target) right --;
			else if(nums[mid] < target) left ++;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 4, 6, 8, 9};
		int target = 6;
		System.out.println(new BinarySearch().binarySearch(nums, target));
	}
}
