package test.hp.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 102. 二叉树的层次遍历
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 * @author hp
 *
 */
public class BTLevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        levelOrder(root, result, 0);
        return result;
    }
	
	private void levelOrder(TreeNode root, List<List<Integer>> result,  Integer depth) {
		if(root == null) return;
		if(depth >= result.size()) {
			result.add(new LinkedList<Integer>());
		}
		result.get(depth).add(root.val); 
		if(root.left != null) levelOrder(root.left, result, depth+1);
		if(root.right != null) levelOrder(root.right, result, depth+1);
	}
}
