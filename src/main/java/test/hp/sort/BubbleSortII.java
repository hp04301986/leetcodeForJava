package test.hp.sort;

public class BubbleSortII {
	public static int[] sort(int[] nums) {
		if(nums == null || nums.length == 0) return nums;
		int l = nums.length;
		for(int i = 0; i < l; i ++) {
			for(int j = 0; j < l - i - 1; j++) {
				if(nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		nums = sort(nums);
		for(int i: nums) {
			System.out.println(i);
		}
	}
}
