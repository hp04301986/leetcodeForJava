package test.hp.leetcode;
/**
 * 实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
示例 1:
输入: 4
输出: 2
示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
 * @author hp
 *
 */
public class SqrtX {
	public static int mySqrt(int x) {
		if(x == 0) return 0;
		if(x < 4) return 1;
		int left = 0;
		int right = x;
		int m = x;
		int lessm = 0;
		int morem = x;
		while(left <= right) {
			m = (left + right) / 2;
			lessm = m -1;
			morem = m + 1;
			if (x / m == m) {
				return m;
			}else if((x / m) > m) {
				if ((x / morem) < morem) return m;
				left = m + 1;
			}else if((x / m) < m){
				if ((x / lessm) > lessm) return lessm;
				right = m - 1;
			}
		}
		return m;
    }
	
	public static void main(String[] args) {
		System.out.println(mySqrt(8));
	}
}
