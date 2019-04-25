package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * @author hp
 *
 */
public class BTRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		rightValue(root, res, 0);
		return res;
    }
	
	public void rightValue(TreeNode root, List<Integer> res, Integer depth) {
		if(root == null) return;
		if(depth == res.size()) {
			res.add(root.val);
		}
		rightValue(root.right, res, depth);
		rightValue(root.left, res, depth);
	}
}
