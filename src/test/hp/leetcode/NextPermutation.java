package test.hp.leetcode;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * ʵ�ֻ�ȡ��һ�����еĺ������㷨��Ҫ���������������������г��ֵ�������һ����������С�
�����������һ����������У��������������г���С�����У����������У���
����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣

������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
1,2,3 �� 1,3,2
3,2,1 �� 1,2,3
1,1,5 �� 1,5,1
 * @author heping
 *
 */
public class NextPermutation {

	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public static void nextPermutation(int[] nums) {
		if(nums != null && nums.length >= 2) {
			//�Ӻ���ǰ�鿴���������ҵ����������ǰһλ��Ҳ�����û��ı߽�
			int index = findTransferPoint(nums);
			//����û��߽���0��˵�����������Ѿ������޷��õ��������ͬ������ɵ�������������С��
			if(index == 0) {
				Arrays.sort(nums);
				return;
			}
			//�������������ǰһλ������������ũ�ոմ����������ֽ���λ��
			System.out.println(index);
			exangeHead(nums, index);
			//��ԭ����������ת��˳��
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
	 * ��ԭ����������ת��˳��
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
