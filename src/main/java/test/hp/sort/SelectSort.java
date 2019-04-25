package test.hp.sort;
/**
 * 选择排序
 * @author hp
 *
 */
public class SelectSort {
	public static int[] sort(int[] nums) {
		if(nums == null || nums.length < 2) return nums;
		int l = nums.length;
		for(int i = 0; i < l-1; i ++) {
			int minIndex = i;
			for(int j = i+1; j < l; j ++) {
				if(nums[j] < nums[minIndex]) minIndex = j;
			}
			int tmp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = tmp;
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
