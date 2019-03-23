package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * @author hp
 *
 */
public class MaxDepthOfNaryTree {
	public int maxDepth(Node root) {
		if(root == null) return 0;
        int max = 0;
        for(Node n : root.children){
            max = Math.max(max, maxDepth(n));
        }
        return max+1;
    }
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
}
