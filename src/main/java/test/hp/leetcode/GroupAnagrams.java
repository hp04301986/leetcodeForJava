package test.hp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 * @author hp
 *
 */
public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(strs);
		for(List<String> l : result) {
			System.out.println(l);
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
        	char[] ca = s.toCharArray();
        	Arrays.sort(ca);
        	String temp = Arrays.toString(ca);
        	if(map.containsKey(temp)) {
        		map.get(temp).add(s);
        	}else {
        		List<String> tlist = new ArrayList<String>();
        		tlist.add(s);
        		map.put(temp, tlist);
        	}
        }
        for(String ss : map.keySet()) {
        	result.add(map.get(ss));
        }
        return result;
    }

}
