package test.hp.leetcode;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
(���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2])��
����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 ��
����Լ��������в������ظ���Ԫ�ء�
����㷨ʱ�临�Ӷȱ����� O(log n)����
ʾ�� 1:
����: nums = [4,5,6,7,0,1,2], target = 0
���: 4
ʾ�� 2:
����: nums = [4,5,6,7,0,1,2], target = 3
���: -1
 * @author heping
 *
 */
public class SearchIndex {

	public SearchIndex() {
		// TODO Auto-generated constructor stub
	}
	
	public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
        	int mid = (start + end)/2;
        	int num = nums[mid];
        	//if nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]
        	if((nums[mid] < nums[0]) == (target < nums[0])) {
        		num = nums[mid];
        	}else {
        		num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	}
        	
        	if(num < target) {
        		start = mid + 1;
        	}else if(num > target){
        		end = mid -1;
        	}else {
        		return mid;
        	}
        }
        
        return -1;
    }

}
