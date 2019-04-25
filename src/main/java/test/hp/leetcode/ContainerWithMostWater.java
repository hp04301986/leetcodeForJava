package test.hp.leetcode;

/**
 * ���� n �������� a1��a2��...��an������ÿ����������ã�i, ai����ʾ�� �� n ��ֱ�ߣ�ʹ���� i �������˵㴦�ڣ�i��ai���ͣ�i��0���������ҳ����е�����ֱ�ߣ�ʹ�������� X ���γɵ������ܹ�װ����ˮ��
ע�⣺�㲻����б������n ������2��
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
