package tree;

/*
 Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.
 Note:
 A solution using O(n) space is pretty straight forward. Could you devise 
 a constant space solution?
 * */
public class RecoverBinarySearchTree {
	private TreeNode tn1;
	private TreeNode tn2;
	private TreeNode prev;

	public void recoverTree(TreeNode root) {
		tn1 = null;
		tn2 = null;
		prev = null;
		inorder(root);
		if (tn1 != null && tn2 != null) {
			int tmp = tn1.val;
			tn1.val = tn2.val;
			tn2.val = tmp;
		}
	}

	private void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			if (prev != null && prev.val > root.val) {
				if (tn1 == null && tn2 == null) {
					tn1 = prev;
					tn2 = root;
				} else {
					tn2 = root;
				}
			}
			prev = root; // draw a picture
			inorder(root.right);
		}
	}
}
