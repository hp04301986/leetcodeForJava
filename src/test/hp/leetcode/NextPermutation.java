package test.hp.leetcode;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 * @author heping
 *
 */
public class NextPermutation {

	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void nextPermutation(int[] nums) {
		if(nums != null && nums.length >= 2) {
			//从后向前查看逆序区域，找到逆序区域的前一位，也就是置换的边界
			int index = findTransferPoint(nums);
			//如果置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回最小数
			if(index == 0) {
				Arrays.sort(nums);
				return;
			}
			//交换逆序区域的前一位和逆序区域中农刚刚大于它的数字交换位置
			System.out.println(index);
			exangeHead(nums, index);
			//把原来逆序区域转成顺序
			reverse(nums, index);
			for(int i:nums) {
				System.out.println(i);
			}
		}
    }
	
	/**
	 * find exange point
	 * @param numbers
	 * @return
	 */
	public static int findTransferPoint(int[] numbers) {
		for(int i = numbers.length - 1; i > 0; i --){
			if(numbers[i] > numbers[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * exchange head
	 * @param numbers
	 * @param index
	 * @return
	 */
	public static int[] exangeHead(int[] numbers, int index) {
		int head = numbers[index - 1];
		for(int i = numbers.length - 1; i > 0; i--) {
			if(head < numbers[i]) {
				numbers[index-1] = numbers[i];
				numbers[i] = head;
				break;
			}
		}
		return numbers;
	}
	/**
	 * 把原来逆序区域转成顺序
	 * @param num
	 * @param index
	 * @return
	 */
	public static int[] reverse(int[] num, int index) {
		for(int i = index, j = num.length -1; i < j; i++, j--) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		return num;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 1};
		nextPermutation(a);
	}
}
