package test.hp.leetcode;
/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @author hp
 *
 */
public class LargestRectangle {
	public static int largestRectangleArea(int[] heights) {
		int l = heights.length;
		if(l == 0) return 0;
		if(l == 1) return heights[0];
		int[] lessFromLeft = new int[l];// idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[l];// idx of the first bar the right that is lower than current
		lessFromLeft[0] = -1;
		lessFromRight[l - 1] = l;
		
		for(int i = 1; i< l; i ++) {
			int p = i - 1;
			while (p>=0 && heights[p] >= heights[i]) {
	            p = lessFromLeft[p];
	        }
			System.out.println("lessFromLeft:"+ p);
	        lessFromLeft[i] = p;
		}
		
		for(int i = l-2; i >= 0; i--) {
			int p = i + 1;
			while (p < heights.length && heights[p] >= heights[i]) {
	            p = lessFromRight[p];
	        }
			System.out.println("lessFromRight:"+ p);
			lessFromRight[i] = p;
		}
		int maxArea = 0;
		for(int i = 0; i < l; i ++) {
			maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}
		return maxArea;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,2,0,3,2,4,3,4};
		System.out.println(largestRectangleArea(nums));
	}
}
