package test.hp.leetcode;

/**
 * 
	��һ��ֻ���� '(' �� ')' ���ַ������ҳ������Ч����ȷ�رգ������Ӵ��ĳ��ȡ�
	���� "(()"�����Ч�����Ӵ�Ϊ "()" �����ĳ����� 2��
	��һ������ ")()())"�����Ч�����Ӵ�Ϊ "()()"�����ĳ����� 4��
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
