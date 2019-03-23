package test.hp.leetcode;
/**
 * 200. Number of Islands
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
示例 1:
输入:
11110
11010
11000
00000
输出: 1

示例 2:
输入:
11000
11000
00100
00011
输出: 3
 * @author hp
 *
 */
public class IslandsNumber200 {
	public int numIslands(char[][] grid) {
        int islands = 0;
        int l = grid.length;
        for(int i = 0; i < l; i ++) {
        	for(int j = 0; j < grid[i].length; j ++) {
        		if(grid[i][j] == '1') {
        			infect(grid, i, j);
        			islands ++;
        		}
        	}
        } 
        return islands;
    }
	
	public void infect(char[][] grid, int i, int j) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return;
		}
		grid[i][j] = '2';
		infect(grid, i-1, j);
		infect(grid, i+1, j);
		infect(grid, i, j-1);
		infect(grid, i, j+1);
	}
}
