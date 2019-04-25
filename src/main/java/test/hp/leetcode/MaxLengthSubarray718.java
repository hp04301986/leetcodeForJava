package test.hp.leetcode;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
示例 1:
输入:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出: 3
解释: 
长度最长的公共子数组是 [3, 2, 1]。
说明:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 * @author hp
 *
 */
public class MaxLengthSubarray718 {
	public int findLength(int[] A, int[] B) {
		int l1 = A.length;
        int l2 = B.length;
		if(l1 == 0 || l2 == 0) {
			return 0;
		}
		int[][] dp = new int[l1+1][l2+1];
		int max = 0;
		for(int i = l1-1; i >= 0; i--) {
			for(int j = l2-1; j >= 0; j--) {
				max = Math.max(max, dp[i][j]= (A[i] == B[j]) ? (1 + dp[i+1][j+1]): 0);
			}
		}
        return max;
    }
}
