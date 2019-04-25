package test.hp.leetcode;
/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
示例:
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author hp
 *
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
    	boolean[] notPrime = new boolean[n];
    	int count = 0;
    	for(int i = 2; i < n; i++) {
    		if(notPrime[i] == false) {
    			count ++;
    			for(int j=2; i*j<n; j++) {
    				notPrime[i*j] = true;
    			}
    		}
    	}
    	return count;
    }
}
