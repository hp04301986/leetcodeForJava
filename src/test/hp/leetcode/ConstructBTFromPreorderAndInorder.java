package test.hp.leetcode;
/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 * @author hp
 *
 */
public class ConstructBTFromPreorderAndInorder {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }
	
	private TreeNode build(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if((inStart > inEnd) || (preStart > preorder.length - 1)) return null;
		int rootVal = preorder[preStart];
		TreeNode root = new TreeNode(rootVal);
		int inIndex = 0;
		for(int i = inStart; i <= inEnd; i ++) {
			if(inorder[i] == rootVal) {
				inIndex = i;
				break;
			}
		}
		root.left = build(preStart+1, inStart, inIndex-1, preorder, inorder);
		root.right = build(preStart + 1 + (inIndex - inStart), inIndex+1, inEnd, preorder, inorder);
		
        return root;
	}
}
