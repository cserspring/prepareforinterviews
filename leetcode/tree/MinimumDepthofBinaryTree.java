package tree;

/*
 Given a binary tree, find its minimum depth.

 The minimum depth is the number of nodes along the shortest path from the root node 
 down to the nearest leaf node.
 * */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class MinimumDepthofBinaryTree {
	// Be careful, the path from root to the leaf node
	// For example. root and root.left, just two nodes, return 2
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		if (root.left != null && root.right != null)
			return 1 + (left < right ? left : right);
		return 1 + (root.left == null ? right : left);
	}
}
