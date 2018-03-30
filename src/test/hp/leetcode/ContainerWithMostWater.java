package test.hp.leetcode;

/**
 * 给定 n 个正整数 a1，a2，...，an，其中每个点的坐标用（i, ai）表示。 画 n 条直线，使得线 i 的两个端点处于（i，ai）和（i，0）处。请找出其中的两条直线，使得他们与 X 轴形成的容器能够装最多的水。
注意：你不能倾斜容器，n 至少是2。
 * @author pihe
 *
 */
public class ContainerWithMostWater {

	public ContainerWithMostWater() {
		// TODO Auto-generated constructor stub
	}
	
	public static int maxArea(int[] height) {
        int l = height.length;
        int lowIndex = 0;
        int highIndex = l - 1;
        int max = (highIndex - lowIndex) * Math.min(height[highIndex], height[lowIndex]);
        while(lowIndex < highIndex) {
        	int lowValue = height[lowIndex];
        	int highValue = height[highIndex];
        	int temp = (highIndex-lowIndex) * Math.min(highValue, lowValue);
        	max = temp > max? temp:max;
        	
        	if(height[lowIndex] < height[highIndex]) {
        		lowIndex ++;
        	}else {
        		highIndex --;
        	}
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] a = {0, 2};
		System.out.println(maxArea(a));
	}

}
