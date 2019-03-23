package test.hp.leetcode;

/**
 * 72. Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 * @author hp
 *
 */
public class EditDistance {
	public static int minDistance(String word1, String word2) {
		if(word1.equals(word2)) {
			return 0;
		}
        int l1 = word1.length();
        int l2 = word2.length();
        
        int[] arr = new int[l2+1];
        for(int i = 1; i <= l2; i ++) arr[i] = i;
        for(int i = 1; i <= l1; i ++) {
        	int prev = i;
        	for(int j=1; j <= l2; j ++) {
        		int cur = 0;
        		if(word1.charAt(i-1) == word2.charAt(j-1)) {
        			cur = arr[j-1];
        		}else {
        			cur = Math.min(Math.min(arr[j-1], prev), arr[j]) + 1;
        		}
        		arr[j-1] = prev;
        		prev = cur;
        	}
        	arr[l2] = prev;
        }
        return arr[l2];
    }

	public static void main(String[] args) {
		System.out.println(minDistance("horse", "ros"));
	}
}
