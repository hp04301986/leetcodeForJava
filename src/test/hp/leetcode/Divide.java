package test.hp.leetcode;

/**
 * �������������������� dividend �ͳ��� divisor�������������Ҫ��ʹ�ó˷��������� mod �������
���ر����� dividend ���Գ��� divisor �õ����̡�
ʾ�� 1:
����: dividend = 10, divisor = 3
���: 3
ʾ�� 2:

����: dividend = 7, divisor = -3
���: -2
˵��:
�������ͳ�����Ϊ 32 λ�з���������
������Ϊ 0��
�������ǵĻ���ֻ�ܴ洢 32 λ�з�������������ֵ��Χ�� [-231,  231-1]�������У�����������������򷵻� 231-1��
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
