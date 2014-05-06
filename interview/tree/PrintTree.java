package tree;

/*
A______
| |    |
B C_   D
 | |  |
 E F  G 
 | |  |
 K H  I

  ||
  \/
  
A
|_B
|_C
| |_E
| | |_K
| |_F
|   |_H
|_D
 |_G
   |_I
* */
public class PrintTree {
	public void print(GeneralTreeNode root) {
		print(root, "", 0, false);
	}

	private void print(GeneralTreeNode root, String path, int level,
			boolean isParentIsLast) {
		if (level == 0) {
			System.out.println(root.val);
		} else if (level == 1) {
			System.out.println("|_" + root.val);
			path += isParentIsLast ? "  " : "| ";
		} else {
			System.out.println(path + "|_" + root.val);
			path += isParentIsLast ? "  " : "| ";
		}
		int n = root.children.size();
		for (int i = 0; i < n; ++i) {
			print(root.children.get(i), path, level + 1, i == n - 1 ? true
					: false);
		}
	}

	public static void main(String args[]) {
		GeneralTreeNode root = new GeneralTreeNode(0);
		GeneralTreeNode node1 = new GeneralTreeNode(1);
		GeneralTreeNode node2 = new GeneralTreeNode(2);
		GeneralTreeNode node3 = new GeneralTreeNode(3);
		GeneralTreeNode node4 = new GeneralTreeNode(4);
		GeneralTreeNode node5 = new GeneralTreeNode(5);
		GeneralTreeNode node6 = new GeneralTreeNode(6);
		GeneralTreeNode node7 = new GeneralTreeNode(7);
		GeneralTreeNode node8 = new GeneralTreeNode(8);
		GeneralTreeNode node9 = new GeneralTreeNode(9);
		root.children.add(node1);
		root.children.add(node2);
		root.children.add(node3);
		node2.children.add(node4);
		node2.children.add(node5);
		node4.children.add(node7);
		node5.children.add(node8);
		node3.children.add(node6);
		node6.children.add(node9);

		PrintTree p = new PrintTree();
		p.print(root);
	}
}
