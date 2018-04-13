package test.hp.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
ʾ��:
���룺"23"
�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
˵��:
��������Ĵ��ǰ��ֵ������еģ��������������ѡ��������˳��
 * @author heping
 *
 */
public class LetterCombination {

	public LetterCombination() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits == null || digits.isEmpty()) {
			return ans;
		}
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i = 0; i<digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i) {
				String t = ans.remove();
				System.out.println(t);
				for(char s: mapping[x].toCharArray()) {
					ans.add(t+s);
				}
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		//System.out.println(letterCombinations("23456789"));
		letterCombinations("23456789");
	}

}
