package test.hp.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
 * @author hp
 *
 */
public class BTZigzagLevelOrderTravel2 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		levelOrder(root, result, 0);
		for(int i = 0; i < result.size(); i ++) {
			if(i % 2 != 0) {
				List<Integer> tmp = result.get(i);
				result.set(i, reverList(tmp));
			}
		}
		return result;
    }
	
	public void levelOrder(TreeNode root, List<List<Integer>> result, int depth) {
		if(root == null) return;
		if(depth >= result.size()) {
			result.add(new LinkedList<Integer>());
		}
		result.get(depth).add(root.val);
		if(root.left != null) levelOrder(root.left, result, depth+1);
		if(root.right != null) levelOrder(root.right, result, depth+1);
	}
	
	public List<Integer> reverList(List<Integer> tmp) {
		int l = tmp.size();
		if(l == 1) return tmp;
		List<Integer> res = new ArrayList<Integer>();
		for(int i = l-1; i >= 0; i --) {
			res.add(tmp.get(i));
		}
		return res;
	}
}
