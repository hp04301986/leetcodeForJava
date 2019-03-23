package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
 * @author hp
 *
 */
public class PalindromePartition {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if(s == null || s.length() == 0) return result;
		getPartitions(result, new ArrayList<>(), s, 0);
		return result;
    }
	
	public void getPartitions(List<List<String>> result, List<String> tmp, String s, int l) {
		if(l == s.length()) {
			result.add(new ArrayList<>(tmp));
			return;
		}
		for(int r = l; r < s.length(); r++) {
			if(isPalindrome(s, l, r)) {
				tmp.add(s.substring(l, r+1));
				getPartitions(result, tmp, s, r + 1);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
	
	public boolean isPalindrome(String s, int l, int r) {
		while((l < r) && (s.charAt(l) == s.charAt(r))) {
			l ++;
			r --;
		}
		return l >= r;
	}
}
