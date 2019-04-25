package test.hp.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
输入: S = "3z4"
输出: ["3z4", "3Z4"]
输入: S = "12345"
输出: ["12345"]
 * @author heping
 *
 */
public class LetterCasePermutation {

	public LetterCasePermutation() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<String> letterCasePermutation(String S) {
		LinkedList<String> result = new LinkedList<String>();
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
		if(pattern.matcher(S).matches()) {
			result.add(S);
		}else {
			result.add(S);
			for(int i = 0; i < S.length(); i ++) {
				char c = S.charAt(i);
	        	if(Character.isLetter(c)) {
	        		for (int size = result.size(); size > 0; size--) {
	                    String s = result.poll();//找到并删除表头
	                    String left = s.substring(0, i);
	                    String right = s.substring(i + 1);
	                    result.add(left + Character.toLowerCase(c) + right);
	                    result.add(left + Character.toUpperCase(c) + right);
	                }
	        	}
	        }
		}
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(letterCasePermutation("dnTJ"));
	}

}
