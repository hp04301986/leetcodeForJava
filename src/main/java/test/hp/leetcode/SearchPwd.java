package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchPwd {
	public static void callFullPwd(ArrayList<String> I, ArrayList<String> result) {
		if (result.size() == I.size()) {
			System.out.println(result);
			return;
		}
		for (String letter: I) {
			ArrayList<String>  newResult = (ArrayList<String>) result.clone();
			newResult.add(letter);
			callFullPwd(I, newResult);
		}
	}
	public static void callSpecNumPwd(ArrayList<String> I, int num, ArrayList<String> result) {
		if(num == 0) {
			System.out.println(result);
			return;
		}
		for(String letter: I) {
			ArrayList<String> newResult = (ArrayList<String>) result.clone();
			newResult.add(letter);
			callSpecNumPwd(I, num-1, newResult);
		}
	}
	
	public static void callPwdtoList(ArrayList<String> I, int num, String pwd, ArrayList<String> list){
		if(num == 0) {
			list.add(pwd);
			return;
		}
		for(String letter : I) {
			String tmp = pwd + letter;
			callPwdtoList(I, num-1, tmp, list);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> I = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
		//callSpecNumPwd(I,4, new ArrayList<String>());
		ArrayList<String> res = new ArrayList<String>();
		callPwdtoList(I, 4, "", res);
		System.out.println(res.size());
		for(String s: res) {
			System.out.println(s);
		}
	}
}
