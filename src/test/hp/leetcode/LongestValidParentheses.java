package test.hp.leetcode;

/**
 * 
	给一个只包含 '(' 和 ')' 的字符串，找出最长的有效（正确关闭）括号子串的长度。
	对于 "(()"，最长有效括号子串为 "()" ，它的长度是 2。
	另一个例子 ")()())"，最长有效括号子串为 "()()"，它的长度是 4。
 * @author heping
 *
 */
public class LongestValidParentheses {

	public LongestValidParentheses() {
		// TODO Auto-generated constructor stub
	}
	
	public static int longestValidParentheses(String s) {
        java.util.Stack<Integer> ss = new java.util.Stack<Integer>();
        int result = 0;
        ss.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && ss.size() > 1 && s.charAt(ss.peek()) == '(') {
            	ss.pop();
                result = Math.max(result, i - ss.peek());
            } else {
            	ss.push(i);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()()"));
	}

}
