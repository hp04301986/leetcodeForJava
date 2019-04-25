package test.hp.leetcode;
/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author hp
 *
 */
public class SpiralMatrix2 {
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int rowBegin = 0;
		int rowEnd = n - 1;
		int colBegin = 0;
		int colEnd = n - 1;
		int num = 1;
		while ((rowBegin <= rowEnd) && (colBegin <= colEnd)) {
			// --> right
			for(int i = colBegin; i <= colEnd; i ++) {
				result[rowBegin][i] = num ++;
			}
			rowBegin ++;
			// --> down
			for(int j = rowBegin; j <= rowEnd; j ++) {
				result[j][colEnd] = num ++;
			}
			colEnd --;
			// -->left
			for(int i = colEnd; i >= colBegin; i --) {
				result[rowEnd][i] = num ++;
			}
			rowEnd --;
			// --> up
			for(int j = rowEnd; j >= rowBegin; j --) {
				result[j][colBegin] = num ++;
			}
			colBegin ++;
		}
        return result;
    }
	public static void main(String[] args) {
		int num = 4;
		int[][] a = generateMatrix(num);
		for (int i = 0; i < num; i ++) {
			for (int j = 0; j < num; j ++) {
				System.out.println(a[i][j]);
			}
		}
	}
}
