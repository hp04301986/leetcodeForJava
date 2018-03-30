package test.hp.leetcode;

/**
 * 
将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：（下面这样的形状）
P   A   H   N
A P L S I I G
Y   I   R
之后按逐行顺序依次排列："PAHNAPLSIIGYIR"
实现一个将字符串进行指定行数的转换的函数:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) 应当返回 "PAHNAPLSIIGYIR" 。
 * @author pihe
 *
 */
public class ZigZapConversion {

	public ZigZapConversion() {
		// TODO Auto-generated constructor stub
	}
	
    public static String convert(String s, int numRows) {
    	if(numRows <= 1) {
    		return s;
    	}
    	StringBuffer[] result = new StringBuffer[numRows];
    	char[] a = s.toCharArray();
    	int length = a.length;
    	for(int i = 0; i < numRows; i ++) {
    		result[i] = new StringBuffer();
    	}
    	int index = 0;
    	while(index < length) {
    		for(int i = 0; i < numRows && index < length; i ++) {
    			result[i].append(a[index++]);
    		}
    		for(int i = numRows-2; i >=1 && index <length; i --) {
    			result[i].append(a[index ++]);
    		}
    	}
    	for(int i = 1; i < result.length;i ++) {
    		result[0].append(result[i]);
    	}
    	
        return result[0].toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}

}
