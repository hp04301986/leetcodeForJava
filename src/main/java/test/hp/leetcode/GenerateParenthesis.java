package test.hp.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
例如，给出 n = 3，生成结果为：
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
