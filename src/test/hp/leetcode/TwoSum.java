package test.hp.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * @author pihe
 *
 */
public class TwoSum {
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 18;
		System.out.print(new TwoSum().twoSum(numbers, target)[0]);
	}
	
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; map.put(numbers[i], ++i)) 
            if (map.containsKey(target - numbers[i])) 
                return new int[]{map.get(target - numbers[i]),i+1};
        return new int[]{0,0};
	}

}
