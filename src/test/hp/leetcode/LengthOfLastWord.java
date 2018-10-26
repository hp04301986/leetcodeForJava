package test.hp.leetcode;

import java.util.List;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
Example:
Input: "Hello World"
Output: 5
 * @author hp
 *
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0) {
        	return 0;
        }
        String[] sSplit = s.trim().split(" ");
        return(sSplit[sSplit.length - 1].length());
    }
}
