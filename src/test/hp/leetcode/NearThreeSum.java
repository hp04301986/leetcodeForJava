package test.hp.leetcode;

import java.util.Arrays;

/**
 * ����һ������ n ������������ S���ҳ� S �е���������ʹ�����ǵĺ���������� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����һ���𰸡�
���磬�������� S = {-1 2 1 -4}, ���� target = 1.
�� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).

 * @author heping
 *
 */
public class NearThreeSum {

	public NearThreeSum() {
		// TODO Auto-generated constructor stub
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int cap = 999999999;
        Arrays.sort(nums);
        int l = nums.length;
        for(int i=0; i<l; i++) {
        	int sum = target - nums[i];
        	int j = i+1;
        	int k = l-1;
        	while(j < k) {
        		if(nums[j] + nums[k] == sum) {
        			return target;
        		}else if(nums[j] + nums[k] < sum) {
        			if(Math.abs(cap) > Math.abs(sum - nums[j] - nums[k])) {
        				cap = sum - nums[j] - nums[k];
        				result = nums[i]+ nums[j]+nums[k];
        			}
        			j++;
        		}else if(nums[j] + nums[k] > sum) {
        			if(Math.abs(cap) > Math.abs(sum - nums[j] - nums[k])) {
        				cap = sum - nums[j] - nums[k];
        				result = nums[i]+ nums[j]+nums[k];
        			}
        			k--;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {-1, 2, 1, -4};
		System.out.println(threeSumClosest(nums, 1));
	}
}
