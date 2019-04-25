package test.hp.leetcode;
/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
示例:
输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
 * @author hp
 *
 */
public class NQueensII {
	
	int count = 0;
	public int totalNQueens(int n) {
		boolean[] cols = new boolean[n];
		boolean[] d1 = new boolean[2 * n];
		boolean[] d2 = new boolean[2 * n];
		backtracking(0, cols, d1, d2, n);
		return count;
	}
	
	/**
	 * This is a classic backtracking problem.
	Start row by row, and loop through columns. At each decision point, skip unsafe positions by using three boolean arrays.
	Start going back when we reach row n.
	45度 line is y = x + b
	135度 line is y = -x + b
	in another word, 45 degree y - x is constant, and 135 degree y + x is constant.
	Here b is shifted to [0~2n), so y-x and y+x can be trackable.
	 * @param row
	 * @param cols
	 * @param d1
	 * @param d2
	 * @param n
	 */
	public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
		if(row == n) count ++;
		for(int col = 0; col < n; col++) {
			int id1 = col - row + n;
			int id2 = col + row;
			if(cols[col] || d1[id1] || d2[id2]) continue;
			
			cols[col] = true;
			d1[id1] = true;
			d2[id2] = true;
			backtracking(row + 1, cols, d1, d2, n);
			cols[col] = false;
			d1[id1] = false;
			d2[id2] = false;
		}
	}
}
