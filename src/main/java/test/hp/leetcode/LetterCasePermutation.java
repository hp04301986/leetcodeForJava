package test.hp.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * ����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�
ʾ��:
����: S = "a1b2"
���: ["a1b2", "a1B2", "A1b2", "A1B2"]
����: S = "3z4"
���: ["3z4", "3Z4"]
����: S = "12345"
���: ["12345"]
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
	                    String s = result.poll();//�ҵ���ɾ����ͷ
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
