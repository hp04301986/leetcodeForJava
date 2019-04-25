package test.hp.leetcode;
/**
 * 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
示例 1: 
输入: [5,7]
输出: 4

示例 2:
输入: [0,1]
输出: 0
 * @author hp
 *
 */
public class BitAndOperation201 {
	public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) {
        	return 0;
        }
        int moveFactor = 1;
        while(m != n) {
        	m >>= 1;
        	n >>= 1;
        	moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
