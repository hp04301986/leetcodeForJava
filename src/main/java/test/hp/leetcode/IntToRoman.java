package test.hp.leetcode;

/**
 * ����һ������������תΪ�������֡�
	���뱣֤�� 1 �� 3999 ֮�䡣
 * @author heping
 *
 */
public class IntToRoman {

	public IntToRoman() {
		// TODO Auto-generated constructor stub
	}
	
	public static String intToRoman(int num) {
		if(num >3999) {
        	return "M";
        }
        if(num < 1){
            return "";
        }
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
	
	public static void main(String[] args) {
		System.out.println(intToRoman(900));
	}

}
