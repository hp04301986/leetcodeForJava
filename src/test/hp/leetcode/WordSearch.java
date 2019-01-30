package test.hp.leetcode;
/**
 * 79
 * @author hp
 *
 */
public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		char[] w = word.toCharArray();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (isExist(board, i, j, w, 0))
					return true;
			}
		}
		return false;
	}

	public static boolean isExist(char[][] board, int i, int j, char[] w, int index) {
		if (index == w.length)
			return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
			return false;
		if (board[i][j] != w[index])
			return false;
		// it means when we search the board time and time again, in order to avoid
		// repeat work, we need to mark the searched character, the naive solution is to
		// create another boolean matrix, but it will costs a lot of space, if we do it
		// with bit mask we can make the searched character to a special character, and
		// when we search it again, it will never match any character we met before,
		// which is another way to avoid repeat work. When we finish the search start
		// from board[i][j] this time, in order to prepare for the next round search, we
		// need to revel the mask, recover the character which is masked, so we do
		// board[y][x] ^= 256 again.
		board[i][j] ^= 256;
		boolean exist = isExist(board, i, j + 1, w, index + 1) || isExist(board, i, j - 1, w, index + 1)
				|| isExist(board, i + 1, j, w, index + 1) || isExist(board, i - 1, j, w, index + 1);
		board[i][j] ^= 256;
		return exist;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCB"));
	}
}
