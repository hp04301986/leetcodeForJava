package test.hp.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
示例: 
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 * @author hp
 *
 */
public class HappyNumber202 {
	public static boolean isHappy(int n) {
		if(n == 0) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		long sum = (long) n;
		Set<Long> set = new HashSet<Long>();
		while(sum != 1l) {
			sum = getSum(sum);
			if(!set.add(sum)) {
				return false;
			}
		}
		return true;
    }
	
	public static long getSum(long n) {
		long res = 0;
		while(n != 0) {
			res += Math.pow(n%10, 2);
			n /= 10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(7));
	}
}
