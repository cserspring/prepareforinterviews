package tree;

class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		val = x;
		left = null;
		right = null;
	}
}

/*
 * Build Binary Search Tree from Preorder. As we know, a preorder can determine
 * a tree uniquely. Every time, we cut the array into left and right based on
 * the first element.
 */
public class BuildBSTFromPreorder {
	// private static int start = 0;
	public Node tree(int[] num) {
		int n = num.length;
		if (n == 0)
			return null;
		return buildTree(num, 0, n - 1);
	}

	private Node buildTree(int[] num, int start, int end) {
		if (start > end)
			return null;
		Node root = new Node(num[start]);
		int i = start + 1;
		for (; i <= end; ++i) {
			if (num[i] > num[start])
				break;
		}
		root.left = buildTree(num, start + 1, i - 1);
		root.right = buildTree(num, i, end);
		return root;
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BuildBSTFromPreorder b = new BuildBSTFromPreorder();
		int[] num = { 30, 20, 10, 40, 35, 50 };
		Node root = b.tree(num);
		b.inorder(root);
	}

}
