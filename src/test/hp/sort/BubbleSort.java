package test.hp.sort;

public class BubbleSort {
	
	public static void main(String[] args) {
		
	}
	
	private static void sort(int array[]) {
		int tmp = 0;
		//最后一次交换的位置
		int lastExchangeIndex = 0;
		//无序数列的边界，每次比较只需要比到这里为止
		int sortBorder = array.length - 1;
		for(int i = 0; i < array.length; i ++) {
			//有序标志，每一轮的初始是true
			boolean isSorted = true;
			for(int j = 0; j < sortBorder; j++) {
				if(array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j+1];
					array[j + 1] = tmp;
					//有元素交换，所以不是有序，标记为false
					isSorted = false;
					//把无序数列的边界更新为最后一次交换元素
					lastExchangeIndex = j;
				}
			}
			sortBorder = lastExchangeIndex;
			if(isSorted) {
				break;
			}
		}
	}
}
