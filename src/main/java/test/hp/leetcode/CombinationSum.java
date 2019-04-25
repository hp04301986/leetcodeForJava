package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�
candidates �е����ֿ����������ظ���ѡȡ��
˵����
�������֣����� target��������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:
����: candidates = [2,3,6,7], target = 7,
����⼯Ϊ:
[
  [7],
  [2,2,3]
]
ʾ�� 2:
����: candidates = [2,3,5], target = 8,
����⼯Ϊ:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * @author heping
 *
 */
public class CombinationSum {

	public CombinationSum() {
		// TODO Auto-generated constructor stub
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<Integer>(tempList));
		else {
			for(int i = start; i < nums.length; i ++) {
				tempList.add(nums[i]);
				System.out.println(tempList);
				backtrack(list, tempList, nums, remain-nums[i], i);
				tempList.remove(tempList.size()-1);
			}
		}
	}

}
