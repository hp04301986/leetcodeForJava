package test.hp.leetcode;
/**
 * 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
你可以假设版本字符串非空，并且只包含数字和 . 字符。
 . 字符不代表小数点，而是用于分隔数字序列。
例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
示例 1:
输入: version1 = "0.1", version2 = "1.1"
输出: -1
示例 2:
输入: version1 = "1.0.1", version2 = "1"
输出: 1
 * @author hp
 *
 */
public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] num1 = version1.split("\\.");
		String[] num2 = version2.split("\\.");
		int l1 = num1.length;
		int l2 = num2.length;
		int n1 = 0;
		int n2 = 0;
		int l = Math.min(l1, l2);
		for(int i=0; i < l; i ++) {
			n1 = Integer.valueOf(num1[i]);
			n2 = Integer.valueOf(num2[i]);
			if(n1 > n2) return 1;
			else if(n1 < n2) return -1;
			else continue;
		}
		if(l1 > l2) {
			for(int i=l2; i< l1; i++) {
				if(Integer.valueOf(num1[i])>0) return 1;
			}
		}else if(l1 < l2) {
			for(int i=l1; i< l2; i++) {
				if(Integer.valueOf(num2[i])>0) return -1;
			}
		}
		return 0;
    }
	
	public static void main(String[] args) {
		System.out.println(compareVersion("0.1", "1.1"));
	}
}
