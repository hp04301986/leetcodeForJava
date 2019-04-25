package test.hp.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
 * @author hp
 *
 */
public class BTLevelOrderII {
	public List<List<Integer>> levelOrderBottomII(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null) return list;
		levelOrder(root, list, 0); 
		List<List<Integer>> result = new ArrayList<>();
		for(int i = list.size()-1; i >= 0; i--) {
			result.add(list.get(i));
		}
        return result;
    }
	
	private void levelOrder(TreeNode root, List<List<Integer>> list, int depth) {
		if(root == null) return;
		if(depth >= list.size()) {
			list.add(new LinkedList<Integer>());
		}
		list.get(depth).add(root.val);
		if(root.left != null) levelOrder(root.left, list, depth + 1);
		if(root.right != null) levelOrder(root.right, list, depth + 1);
	}
}
