package test.hp.leetcode;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
示例 1:
输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:
被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [-231,  231-1]。本题中，如果除法结果溢出，则返回 231-1。
 * @author heping
 *
 */
public class Divide {

	public Divide() {
		// TODO Auto-generated constructor stub
	}
	
	public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE) {
        	if(divisor == -1) {
        		return Integer.MAX_VALUE;
        	}
        }
        long a = dividend < 0? -(long)dividend : (long)dividend;
        long b = divisor < 0? -(long)divisor : (long)divisor;
        int res = recurse(a, b, 1);
        if(dividend < 0 && divisor < 0) {
        	return res;
        }else if(dividend < 0 || divisor < 0) {
        	return -res;
        }
        return res; 
    }
	
	public static int recurse(long x, long y, int count) {
		System.out.println(x + ", "+ y + ", "+count);
		if(x <= 0 || count == 0) {
			return 0;
		}
		if(y > x) {
			return recurse(x, y >>> 1, count >>> 1);
		}else {
			return recurse(x -y, y + y, count + count) +count;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(divide(7, -3));
	}

}
