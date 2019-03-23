package test.hp.sort;

public class QuickSortII {
	public int[] quickSort(int[] nums) {
		realAction(nums, 0, nums.length - 1);
		return nums;
	}
	
	public void realAction(int[] nums, int start, int end) {
		if(start >= end) return;
		int stand = nums[start];
		int i = start;
		int j = end;
		while(i < j) {
			while(i < j && nums[j] >= stand) j --;
			if(i < j) nums[i++] = nums[j];
			while(i < j && nums[i] < stand) i ++;
			if(i < j) nums[j--] = nums[i];
		}
		nums[i] = stand;
		realAction(nums, start, i-1);
		realAction(nums, i+1, end);
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		new QuickSortII().quickSort(nums);
		for(int i: nums) {
			System.out.println(i);
		}
	}
}
