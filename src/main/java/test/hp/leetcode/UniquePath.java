package test.hp.leetcode;

/**
 * 62. 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
	机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
	问总共有多少条不同的路径？
 * @author hp
 *
 */
public class UniquePath {
	public int uniquePaths(int m, int n) {
		int steps = n + m - 2;// how much steps we need to do
		int k = m - 1; // number of steps that need to go down
		double res = 1;
		// here we calculate the total possible path number 
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++)
            res = res * (steps - k + i) / i;
		return (int)res;
    }
	
}
