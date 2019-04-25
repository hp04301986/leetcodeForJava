package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * iherb面试题
 * 输入2， 输出1-99， 输入3， 输出1-999...
 * @author hp
 *
 */
public class IHerb {
	
	public static List<String> getInteger(int n) {
		List<String> list = new ArrayList<String>();
		if(n == 0) {
			return list;
		}
		for(int i = 1; i <= 9; i ++) {
			list.add(String.valueOf(i));
		}
		int oldSize = 0;
		int newSize = list.size();
		for(int i = 1; i < n; i ++) {
			List<String> tmpList = new ArrayList<String>();
			for(int k = oldSize; k < newSize; k ++) {
				String tmp = list.get(k);
				for(int j = 0; j <= 9; j ++) {
					tmpList.add(tmp+String.valueOf(j));
				}
			}
			oldSize = list.size();
			list.addAll(tmpList);
			newSize = list.size();
		}
		return list;
	}
	public static void main(String[] args) {
		List<String> list = getInteger(5);
		for(String val : list) {
			System.out.println(val);
		}
	}
}
