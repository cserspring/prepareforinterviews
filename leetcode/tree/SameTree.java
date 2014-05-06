package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 Given two binary trees, write a function to check if they are equal or not.

 Two binary trees are considered equal if they are structurally identical and 
 the nodes have the same value.
 * */
public class SameTree {
	// Recursive method
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		return (p.val == q.val) && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}

	// Iterative method
	public boolean isSameTree_Iterative(TreeNode p, TreeNode q) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(p);
		q2.add(q);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode node1 = q1.poll();
			TreeNode node2 = q2.poll();
			if (node1 == null && node2 == null)
				continue;
			if (node1 == null || node2 == null)
				return false;
			if (node1.val != node2.val)
				return false;
			q1.add(node1.left);
			q1.add(node1.right);
			q2.add(node2.left);
			q2.add(node2.right);
		}
		return true;
	}
}
