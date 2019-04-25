package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
说明：
给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
 * @author hp
 *
 */
public class PermutationsSeq {
	public String getPermutation(int n, int k) {
		if (k == 0 || k > getNFactorial(n)) {
			return null;
		}
		if(n == 1) {
			return "1";
		}
		List<String> list = new ArrayList<String>();
		for(int i=1; i <= n; i ++) {
			list.add(String.valueOf(i));
		}
		
		StringBuilder result = new StringBuilder(n);
		return getResult(result, list, k, n).toString();
    }
	
	public StringBuilder getResult(StringBuilder result, List<String> list, int k, int target) {
		if(result.length() == target) return result;
		int n = list.size();
		if(n == 1) return result.append(list.get(0));
		int fn = getNFactorial(n-1);
		int left = k % fn;
		int start = left == 0 ? k/fn : k/fn+1;
		System.out.println("left="+left);
		System.out.println("start="+start);
		if(start == 0) {
			result.append(list.get(list.size() - 1));
			list.remove(list.size() - 1);
		}else {
			result.append(list.get(start - 1));
			list.remove(start - 1);
		}
		return getResult(result, list, left, target);
	}
	
	public int getNFactorial(int n){
        if(n==0){
            return 1;
        }
        return n * getNFactorial(n-1);
    }
	
	public static void main(String[] args) {
		System.out.println(new PermutationsSeq().getPermutation(4, 2));
	}
}
