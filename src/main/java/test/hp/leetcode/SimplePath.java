package test.hp.leetcode;
/**
 * 71. Simplify Path
 * 给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
例如，
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

边界情况:

你是否考虑了 路径 = "/../" 的情况？
在这种情况下，你需返回 "/" 。
此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 * @author hp
 *
 */
public class SimplePath {
	public static String simplifyPath(String path) {
		if("".equals(path) || "/".equals(path)) {
			return path;
		}
        String[] arr = path.split("/");
        java.util.Stack<String> s = new java.util.Stack<String>();
        for(String ss : arr) {
        	if(".".equals(ss) || "".equals(ss)) {
        		continue;
        	}else if("..".equals(ss)) {
        		if(!s.isEmpty()) {
        			s.pop();
        		}
        	}else {
        		s.push(ss);
        	}
        }
        if(s.isEmpty()) {
        	return "/";
        }
        java.util.Stack<String> s2 = new java.util.Stack<String>();
        while(!s.isEmpty()) {
        	s2.push(s.pop());
        }
        String res = "";
        while(!s2.isEmpty()) {
        	res += "/" + s2.pop();
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/../../.."));
	}
}
