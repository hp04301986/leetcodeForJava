package test.hp.leetcode;

public class Stack {

	public static void main(String[] args) {
		int[] a = new int[] {};
		int newValue = 0;
		int index = a.length;
		while(index > 0) {
			a[index] = a[index-1];
			index --;
		}
		a[0] = newValue;
	}

}
