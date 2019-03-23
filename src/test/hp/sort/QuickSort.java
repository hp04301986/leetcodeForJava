package test.hp.sort;

public class QuickSort {
	public static void quick_sort(int[] nums, int left, int right) {
		if(left < right) {
			int i = left; 
			int j = right;
			int tmp = nums[left];
			while(i < j) {
				//从右向左找小于tmp的值来填num[left]
				while(i < j && tmp <= nums[j]) j--;
				if(i< j) {
					nums[i] = nums[j];//将nums[j] 填到nums[i]中，nums[j]就形成了一个新的坑
					i ++;
				}
				//从左向右找大于tmp的值来填s[j]
				while(i < j && nums[i] < tmp) i ++;
				if(i < j) {
					nums[j] = nums[i]; //将nums[i]填到nums[j]中，num[i]就形成了一个新的坑
					j --;
				}
			}
			//退出时，i = j, 将x填到这个坑中
			nums[i] = tmp;
			quick_sort(nums, left, i-1);//递归
			quick_sort(nums, i+1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		int l = nums.length;
		int left = 0;
		int right = l - 1;
		quick_sort(nums, left, right);
		for(int i: nums) {
			System.out.println(i);
		}
	}
}
