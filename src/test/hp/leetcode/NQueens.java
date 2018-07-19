package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击.

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 * @author hp
 *
 */
public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		if(n == 1) {
			List<String> temp = new ArrayList<String>();
			temp.add("Q");
			res.add(temp);
		}
		if(n <= 3) {
			return res;
		}
		helper(n, res, new ArrayList<Integer>(), 0);
        return res;
    }
	
	void helper(int n, List<List<String>> res, List<Integer> rowQpos, int row) {
		if(rowQpos.size() == n) {
			List<String> board = new ArrayList<String>();
			for(Integer rq: rowQpos) {
				char[] bc = new char[n];
				Arrays.fill(bc, '.');
				bc[rq] = 'Q';
				board.add(String.valueOf(bc));
			}
			res.add(board);
		}
		for(int i = 0; i < n; i ++) {
			if(!isValid(rowQpos, row, i)) continue;
			rowQpos.add(i);
			helper(n, res, rowQpos, row+1);
			rowQpos.remove(rowQpos.size() - 1);
		}
	}
	
	boolean isValid(List<Integer> rowQpos, int row, int col) {
		for(int i = 0; i < rowQpos.size(); i ++) {
			if(col == rowQpos.get(i)) return false;
			if(row - col == i - rowQpos.get(i)) return false;
			if(row + col == i + rowQpos.get(i)) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
	}
}
