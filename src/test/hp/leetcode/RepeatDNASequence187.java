package test.hp.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatDNASequence187 {
	public List<String> findRepeatedDnaSequences(String s) {
        Set<String> subs = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();
        int l = s.length();
        for(int i = 0; i+10 < l; i ++) {
        	String tmp = s.substring(i, i + 10);
        	if(!subs.add(tmp)) {
        		repeated.add(tmp);
        	}
        }
        return new ArrayList<String>(repeated);
    }
}
