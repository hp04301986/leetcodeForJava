package test.hp.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of contiguous subarrays whose sum equals to k.
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
 * @author hp
 *
 */
public class SubArraySum {
	
	private int subarraySum(int[] nums, int k) {
		if((nums == null) || nums.length < 1) {
			return 0;
		}
		Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
		sums.put(0,  1);
		int prefixSum = 0;
		int count = 0;
		for(int ele : nums) {
			prefixSum += ele;
			count += sums.getOrDefault(prefixSum - k, 0);
			sums.put(prefixSum, sums.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}
}
