package test.hp.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 10亿个int数据去重排序
 * 用long型，一个long型占用8个字节，也就是64位
 * 位图排序
 * @author hp
 *
 */
public class BitMapSort {
	public static int[] bitSort1(int[] array) {
		int max = getMax(array);
		//max也可以换成 int max = 1l << 32, 40亿; 1l << 31, 20亿
		System.out.println(max);
		int N = max/64 + 1;
		long[] bitMap = new long[N];
		int l = array.length;
		for(int i = 0; i < array.length; i ++) {
			bitMap[array[i]/64] = bitMap[array[i]/64] | (1l << (array[i] % 64));
		}
		int k = 0;
		for(int i=0; i < N; i++) {
			for(int j=0; j < 64; j++) {
				if((bitMap[i] & (1l << j)) != 0) {
					array[k++] = i * 64 + j;
				}
			}
		}
		if(k < l) {
			return Arrays.copyOfRange(array, 0, k);
		}
		return array;
	}
	
	public static int getMax(int[] array) {
		int max = array[0];
		int l = array.length;
		for(int i = 1; i < l; i ++) {
			if(array[i] > max) max = array[i];
		}
		return max;
	}
	
	public static void main(String[] args) {
//		int[] array = {1, 2, 6, 4,3, 2, 1, 9, 8, 7, 10000000, 9999999, 888888, 777777};
//		array = bitSort1(array);
//		for(int i = 0; i < array.length; i ++) {
//			System.out.println(array[i]);
//		}
		
		int[] array2 = new int[20];
		Random random = new Random();
		for(int i= 0; i < array2.length; i ++) {
			array2[i] = random.nextInt(1000) - 500;
		}
		System.out.println("排序前:" + Arrays.toString(array2));
		int[] tmp = bitMapSort2(array2);
		System.out.println("排序后:" + Arrays.toString(tmp));
	}
	
	private static int[] bitMapSort2(int[] array) {
		int[] value = getMaxMin(array);
		int N = (value[0] - value[1])/64 + 1;
		long[] bitmap = new long[N];
		int l = array.length;
		for(int i= 0; i < l; i ++) {
			bitmap[(array[i] - value[1])/64] = bitmap[(array[i] - value[1])/64] | (1l << ((array[i] - value[1])%64));
		}
		int k = 0;
		int[] tmp = new int[l];
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < 64; j ++) {
				if((bitmap[i] & (1l << j))!= 0) {
					tmp[k++] = i * 64 + j + value[1];
				}
			}
		}
		if(k < l) {
			return Arrays.copyOfRange(tmp, 0, k);
		}
		return tmp;
	}
	
	public static int[] getMaxMin(int[] array) {
		int max = array[0];
		int min = array[0];
		int l = array.length;
		for(int i = 1; i < l; i ++) {
			if(array[i] > max) {
				max = array[i];
			}else if(array[i] < min) {
				min = array[i];
			}
		}
		return new int[]{max, min};
	}
}
