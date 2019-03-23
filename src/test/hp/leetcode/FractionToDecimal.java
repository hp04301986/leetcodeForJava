package test.hp.leetcode;

import java.util.HashMap;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
如果小数部分为循环小数，则将循环的部分括在括号内。
示例 1:
输入: numerator = 1, denominator = 2
输出: "0.5"
示例 2:
输入: numerator = 2, denominator = 1
输出: "2"
示例 3:
输入: numerator = 2, denominator = 3
输出: "0.(6)"
 * @author hp
 *
 */
public class FractionToDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
        	return "0";
        }
        StringBuilder sb = new StringBuilder();
        //正负符号
        sb.append((numerator > 0) ^ (denominator > 0)? "-": "");
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        //integral part
        sb.append(num/den);
        num %= den;//余数重新赋值给num
        if(num == 0) {
        	return sb.toString();
        }
        // fractional part
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length());
        while(num != 0) {
        	num *= 10;
        	sb.append(num/den);
        	num %= den;
        	if(map.containsKey(num)) {
        		int index = map.get(num);
        		sb.insert(index, "(");
        		sb.append(")");
        		break;
        	}else {
        		map.put(num, sb.length());
        	}
        }
        return sb.toString();
    }
}
