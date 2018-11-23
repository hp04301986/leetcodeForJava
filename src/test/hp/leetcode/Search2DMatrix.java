package test.hp.leetcode;

import java.util.Arrays;

/**
 * 74. Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 * @author hp
 *
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
        	return false;
        }
        int cols = matrix[0].length;
        if(cols == 0) {
        	return false;
        }
        for(int i=0; i < rows; i ++) {
        	int[] arr = matrix[i];
        	Arrays.sort(arr);
        	if(arr[0] > target || arr[cols-1] < target) {
        		continue;
        	}
        	for(int j = 0; j < cols; j ++) {
        		if(arr[j] < target) continue;
        		if(arr[j] == target) return true;
        		if(arr[j] > target) break;
        	}
        }
        return false;
    }
}
