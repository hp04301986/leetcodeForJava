package test.hp.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 6, 7};
		nums = new BubbleSort().sort(nums);
		for(int i : nums) {
			System.out.print(i);
		}
	}
	
	private int[] sort(int[] nums) {
		if(nums == null || nums.length < 2) return nums;
		int l = nums.length;
		for(int i = 0; i < l-1; i ++) {
			for(int j = i + 1; j < l; j ++) {
				int tmp = nums[i];
				if(nums[j] < tmp) {
					nums[i] = nums[j];
					nums[j] = tmp;
				}
			}
		}
		return nums;
	}
}
