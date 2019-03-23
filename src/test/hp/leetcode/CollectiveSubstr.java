package test.hp.leetcode;

public class CollectiveSubstr {
	
	public static String getCollectiveSubstr(String s1, String s2) {
		if(s1.contains(s2)) {
			return s2;
		}
		if(s2.contains(s1)) {
			return s1;
		}
		int l1 = s1.length();
		int l2 = s2.length();
		
		String shortStr = "";
		String longStr = "";
		int sl = 0;
		
		if(l1 <= l2) {
			sl = l1;
			shortStr = s1;
			longStr = s2;
		}else {
			sl = l2;
			shortStr = s2;
			longStr = s1;
		}
		String result = "";
		for(int i=0; i < sl; i ++) {
			for(int j=sl; j>i; j--) {
				String tmp = shortStr.substring(i, j);
				if(longStr.contains(tmp)) {
					if(tmp.length() > result.length()) {
						result = tmp;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(getCollectiveSubstr("abcdef", "bcdaef"));
	}

}
