package test.hp.leetcode;

/**
 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
����㷨ʱ�临�Ӷȱ����� O(log n) ����
��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:
����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]
ʾ�� 2:
����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]
 * @author heping
 *
 */
public class SearchRange {

	public SearchRange() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length < 1) {
			return new int[] {-1, -1};
		}
        return new SearchRange().search(nums, target, 0, nums.length - 1);
    }
	
	public int[] search(int[] nums, int target, int start, int end) {
		if(nums[start] == target  && nums[end] == target) {
			return new int[] {start, end};
		}
		if(nums[start] <= target && nums[end] >= target) {
			int mid = (start + end)/2;
			int[] left = search(nums, target, start, mid);
			int[] right = search(nums, target, mid + 1, end);
			if(left[0] == -1) return right;
			if(right[0] == -1) return left;
			return new int[] {left[0], right[1]};
		}
		return new int[] {-1, -1};
	}
    
	
}
