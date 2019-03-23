package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
示例:
输入: [1,null,2,3]
   1
    \
     2
    /
   3
输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author hp
 *
 */
public class BinaryTreeInorder {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        if(root.left != null) {
        	result.addAll(inorderTraversal(root.left));
        }
        result.add(root.val);
        if(root.right != null) {
        	result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
	
}
