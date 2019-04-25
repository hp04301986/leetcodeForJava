package test.hp.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstr5 {
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return s;
        }
        String res = "";
        for(int i = 0; i < s.length(); i ++){
            String tmp = helper(s, i, i);
            if(tmp.length() > res.length()){
                res = tmp;
            }
            tmp = helper(s, i, i + 1);
            if(tmp.length() > res.length()){
                res = tmp;
            }
        }
        return res;
    }

    public String helper(String s, int l, int r){
        while((l >= 0) && (r < s.length()) && (s.charAt(l) == s.charAt(r))){
            l -= 1;
            r += 1;
        }
        return s.substring(l+1, r);
    }
}
