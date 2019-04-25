package test.hp.leetcode;

public class MaxSameStr {

	public MaxSameStr() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String s1 = "abcabcabcabc";
		String s2 = "abcabcabcd";
		System.out.println(getMaxSameStr(s1, s2));
	}
	
	public static String getMaxSameStr(String s1, String s2) {
		String result = "";
		if((s1 == null) || (s2 == null) || ("".equals(s1)) || ("".equals(s2))) {
			return result;
		}
		if(s1.indexOf(s2) != -1) {
			return s2;
		}else if(s2.indexOf(s1) != -1) {
			return s1;
		}else {
			String temp = "";
			for(int i = 0; i < s1.length(); i ++) {
				for(int j = i +1; j < s1.length(); j ++) {
					temp = s1.substring(i, j+1);
					if((s2.indexOf(temp) != -1) && (temp.length() > result.length())) {
						result = temp;
					}
				}
			}			
		}
		return result;
	}
	

}
