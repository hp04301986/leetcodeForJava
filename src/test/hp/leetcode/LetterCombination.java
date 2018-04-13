package test.hp.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
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
