package test.hp.leetcode;

import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * @author hp
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle){
		int n = triangle.size();
		int[] dp = new int[n+1];
		for(int i = n-1; i >= 0; i --){
            int size = triangle.get(i).size();
            for(int j = 0; j < size; j ++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
