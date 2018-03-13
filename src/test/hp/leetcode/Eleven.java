package test.hp.leetcode;

public class Eleven {

	public static void main(String[] args) {
		int[] a = new int[]{1, 3, 5, 6, 9, 12};
		System.out.print(checkEleven(a));
	}
	
	private static boolean checkEleven(int[] a) {
		int left = 0;
		int right = a.length - 1;
		
		while ((left < right) && (right < a.length)) {
			if(a[left] + a[right] == 11) {
				return true;
			}else if (a[left] + a[right] > 11){
				right --;
			}else if(a[left] + a[right] < 11) {
				left ++;
			}
		}
		return false;
	}

}
