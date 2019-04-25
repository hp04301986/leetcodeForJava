package test.hp.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * ���� n �����������ŵĶ���������д��һ��������ʹ���ܹ��������п��ܵĲ�����Ч��������ϡ�
���磬���� n = 3�����ɽ��Ϊ��
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 * @author heping
 *
 */
public class GenerateParenthesis {

	public GenerateParenthesis() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> result= new LinkedList<String>();
		if(n > 0) {
			generateParenthesisCore("", n, n, result);
		}
		return result;
    }
	
	private static void generateParenthesisCore(String prefix, int left, int right, List<String> result) {
		if(left == 0 && right == 0) {
			result.add(prefix);
		}
		if(left > 0) {
			generateParenthesisCore(prefix+"(", left-1, right, result);
		}
		if(left < right) {
			generateParenthesisCore(prefix+ ")", left, right-1, result);
		}
	}
	
	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		System.out.println(result);
	}

}
