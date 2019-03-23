package test.hp.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 从1亿个数中找出最大的100个
 * @author hp
 *
 */
public class Top100 {
	public static int[] getTop100(int[] inputArray) {
		int maxValue = inputArray[0];
		int l = inputArray.length;
		for(int i = 1; i < l; i++) {
			if(inputArray[i] > maxValue) {
				maxValue = inputArray[i];
			}
		}
		byte[] bitmap = new byte[maxValue + 1];
		for(int i = 0; i < l; i ++) {
			bitmap[inputArray[i]] = 1;
		}
		
		int[] result = new int[100];
		int index = 0;
		int i = maxValue;
		while(index < 100 && i >= 0) {
			if(bitmap[i] == 1) {
				result[index++] = i;
			}
			i --;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int numberCount = 100000000;
		int[] inputArray = new int[numberCount];
		Random random = new Random();
		for(int i = 0; i < numberCount; i ++) {
			inputArray[i] = random.nextInt(numberCount);
		}
		System.out.println("Sort begin...");
		long current = System.currentTimeMillis();
		int[] result = Top100.getTop100(inputArray);
		System.out.println(System.currentTimeMillis() - current);
		System.out.println(Arrays.toString(result));
	}
}
