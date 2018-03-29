package test.hp.leetcode;

/**
 * 各种排序算法
 * @author pihe
 *
 */
public class Sort {

	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,2,4,6,5,3,7};
		quickSort(a, 0, a.length-1);
		for(int aa : a) {
			System.out.println(aa);
		}
		
	}
	
	/**
	 * 冒泡
	 * @param a
	 * @return
	 */
	public static int[] bubbleSort(int[] a) {
		if((a == null) || (a.length == 0)) {
			return a;
		}
		int temp = a[0];
		for(int i = 0; i < a.length; i ++) {
			for (int j = 0; j < a.length - 1; j ++) {
				if(a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
		return a;
	}
	
	/**
	 * 选择排序
	 * @param a
	 * @return
	 */
	public static int[] selectSort(int[] a) {
		if((a == null) || (a.length == 0)) {
			return a;
		}
		int minIndex = 0;
		int temp = a[0];
		for(int i = 0; i<a.length; i ++) {
			minIndex = i;
			for(int j = i + 1; j < a.length; j ++) {
				if(a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			temp = a[minIndex];
			a[minIndex] = a[i];
			a[i] = temp;
		}
		
		return a;
	}
	
	/**
	 * 插入排序
	 * @param a
	 * @return
	 */
	public static int[] insertSort(int[] a) {
		if((a == null) || (a.length == 0)) {
			return a;
		}
		int preIndex = 0;
		int current = a[0];
		for(int i = 1; i < a.length; i ++) {
			preIndex = i - 1;
			current = a[i];
			while((preIndex >= 0) && (a[preIndex] > current)) {
				a[preIndex + 1] = a[preIndex];
				preIndex --;
			}
			a[preIndex + 1] = current;
		}
		
		return a;
	}
	
	/**
	 * 快速排序
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static void quickSort(int[] a, int left, int right) {
		if(left < right) {
			int index = getStandardIndex(a, left, right);
			quickSort(a, left, index);
			quickSort(a, index+1, right);
		}
	}
	
	/**
	 * 找标准索引
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */
	public static int getStandardIndex(int[] a, int left, int right) {
		int standard = a[left];
		int temp = 0;
		while(left < right) {
			while((left<right) && a[right] >= standard) {
				right --;
			}
			a[left] = a[right];
			while((left<right) && a[left] <= standard) {
				left ++;
			}
			//交换
			temp = a[right];
			a[right] = a[left];
			a[left] = temp;
		}
		
		a[left] = standard;
		return left;
	}
	
	

}
