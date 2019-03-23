package test.hp.leetcode;

import org.w3c.dom.Node;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 * @author hp
 *
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		if(root.left == null || root.right == null) return false;
		if(root.left.val == root.right.val) return compare(root.left, root.right);
		return false;
    }
	
	private boolean compare(TreeNode node1, TreeNode node2) {
		boolean flag = false;
		if(node1.left == null && node2.right == null) {
			if(node1.right == null && node2.left == null) return true;
			if(node1.right == null || node2.left == null) return false;
			if(node1.right.val == node2.left.val) flag = compare(node1.right, node2.left);
		}else if(node1.right == null && node2.left == null) {
			if(node1.left == null && node2.right == null) return true;
			if(node1.left == null || node2.right == null) return false;
			if(node1.left.val == node2.right.val) flag = compare(node1.left, node2.right);
		}else {
			if(node1.left == null || node2.right == null) return false;
			if(node1.right == null || node2.left == null) return false;
			if(node1.left.val == node2.right.val && node1.right.val == node2.left.val) {
				flag = compare(node1.left, node2.right);
				if(flag) flag = compare(node1.right, node2.left);
			}
		}
		return flag;
	}
}
