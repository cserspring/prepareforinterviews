package tree;

import java.util.Stack;

/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 * */
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		int rightLimit = Integer.MAX_VALUE;
		int leftLimit = Integer.MIN_VALUE;
		return isValidBST(root, leftLimit, rightLimit);
	}

	public boolean isValidBST_Iterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode cur = stack.pop();
			if (prev != null && cur.val <= prev.val)
				return false;
			prev = cur;
			if (cur.right != null)
				root = cur.right;
		}
		return true;
	}
	
	private boolean isValidBST(TreeNode root, int leftLimit, int rightLimit) {
		if (root == null)
			return true;
		return root.val < rightLimit && root.val > leftLimit
				&& isValidBST(root.left, leftLimit, root.val)
				&& isValidBST(root.right, root.val, rightLimit);
	}
}
