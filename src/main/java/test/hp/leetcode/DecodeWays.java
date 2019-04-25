package test.hp.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:
输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2:
输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * @author hp
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		char[] codes = s.toCharArray();
		int n = codes.length;
		// memo[i] 表示字符串中第 i 位数字与其之后数字的组成的编码总数
		int[] memo = new int[n];
		if(codes[n-1] != '0') memo[n-1] = 1;
		
		for(int i = n-2; i >= 0; i--) {
			//0没有对应值，需要与前一位一起考虑
			if(codes[i] == '0') continue;
			if(codes[i] == '1' || (codes[i] == '2' && codes[i+1] < '7')) {
				if(i == n-2) memo[i] = memo[i+1] + 1;
				//第i位与第i+1位组合的情况(也就是memo[i+2]) + 第i位单独计算的情况(即memo[i+1])
				else memo[i] = memo[i+1] + memo[i + 2];
			}else {
				memo[i] = memo[i+1];
			}
		}
		return memo[0];
    }
}
