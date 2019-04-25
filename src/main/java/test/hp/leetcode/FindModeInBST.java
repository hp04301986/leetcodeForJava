package test.hp.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 501. Find Mode in Binary Search Tree
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].
Note: If a tree has more than one mode, you can return them in any order.
Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 * @author hp
 *
 */
public class FindModeInBST {
	int maxCount = 0;
	public int[] findMode(TreeNode root) {
		if(root == null) return new int[0];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		getNodesMode(root, map);
		
		List<Integer> list = new ArrayList<Integer>();
		for(Integer tmp : map.keySet()) {
			if(map.get(tmp)== maxCount) list.add(tmp);
		}
		int l = list.size();
        int[] result = new int[l];
        for(int i = 0; i < l; i ++) {
        	result[i] = list.get(i);
        }
        return result;
    }
	
	private void getNodesMode(TreeNode root, Map<Integer, Integer> map){
		if(root != null) {
			int key = root.val;
			int val = 1;
			if(map.get(key) != null) val = map.get(key) + 1;
			map.put(key, val);
			if(val > maxCount) {
				maxCount = val;
			}
			if(root.left != null) getNodesMode(root.left, map);
			if(root.right != null) getNodesMode(root.right, map);
		}
	}
}
