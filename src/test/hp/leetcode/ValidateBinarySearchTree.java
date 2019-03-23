package test.hp.leetcode;
/**
 * 98. Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
Input:
    2
   / \
  1   3
Output: true
Example 2:
    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
 * @author hp
 *
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root != null) {
			return isValid(root, null, null);
		}
		return true;
	}
	
	public boolean isValid(TreeNode root, Integer lowLimit, Integer upLimit) {
		if(lowLimit != null && root.val <= lowLimit) return false;
		if(upLimit != null && root.val >= upLimit) return false;
		boolean flag = true;
		if(root.left != null) {
			flag = isValid(root.left, lowLimit, root.val);
		}
		if(!flag) return flag;
		if(root.right != null) {
			flag = isValid(root.right, root.val, upLimit);
		}
		return flag;
	}
}
