package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 179. 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
示例 2:
输入: [3,30,34,5,9]
输出: 9534330
 * @author hp
 *
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
			if(nums == null || nums.length == 0) return "";
			int l = nums.length;
			ArrayList<String> list = new ArrayList<>();
			for(int i=0; i < l; i++) {
				list.add(String.valueOf(nums[i]));
			}
			Collections.sort(list,(a,b) -> (int)(Long.parseLong(b+a) - Long.parseLong(a+b)) );
			StringBuilder sb = new StringBuilder();
			for(String s:list) {
				sb.append(s);
			}
			return sb.toString().replaceFirst("^0+(?!$)","");
    }
}
