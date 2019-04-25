package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * 
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations. Example: Input: "25525511135" Output:
 * ["255.255.11.135", "255.255.111.35"]
 * 
 * @author hp
 *
 */
public class RestoreIpAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if (s == null)
			return result;
		int l = s.length();
		if (l > 12 || l < 4)
			return result;
		for (int a = 1; a <= 3; a++) {
			for (int b = 1; b <= 3; b++) {
				for (int c = 1; c <= 3; c++) {
					if (a + b + c < l) {
						String s1 = s.substring(0, a);
						String s2 = s.substring(a, a + b);
						String s3 = s.substring(a + b, a + b + c);
						String s4 = s.substring(a + b + c);
						if ((s1.length() > 1 && s1.startsWith("0")) || (s2.length() > 1 && s2.startsWith("0"))
								|| (s3.length() > 1 && s3.startsWith("0")) || (s4.length() > 1 && s4.startsWith("0")))
							continue;
						if (Integer.valueOf(s1) <= 255 && Integer.valueOf(s2) <= 255 && Integer.valueOf(s3) <= 255
								&& Integer.valueOf(s4) <= 255) {
							StringBuilder sb = new StringBuilder();
							sb.append(s1).append(".").append(s2).append(".").append(s3).append(".").append(s4);
							result.add(sb.toString());
						}
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.print(new RestoreIpAddress().restoreIpAddresses("25525511135"));
	}
}
