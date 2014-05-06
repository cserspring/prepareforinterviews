package tree;

import java.util.ArrayList;
/*
                             root
                              |
                              A
            /                 |               \
           B                  C                D
    /      |     \    /       |       \   /    |     \
   E       F     G   H        I       J  K     L      M
  /                           |
 N                            O
* */
class GeneralTreeNode {
	int val;
	ArrayList<GeneralTreeNode> children;

	public GeneralTreeNode(int val) {
		this.val = val;
		this.children = new ArrayList<GeneralTreeNode>();
	}
}

public class LCAofGeneralTree {
	public GeneralTreeNode LCA(GeneralTreeNode root, GeneralTreeNode p,
			GeneralTreeNode q) {
		if (root == null)
			return null;
		if (p == null || q == null)
			return p != null ? p : q;
		if (root == p || root == q)
			return root;
		GeneralTreeNode node1 = null;
		GeneralTreeNode node2 = null;
		int n = root.children.size();
		for (int i = 0; i < n; ++i) {
			GeneralTreeNode node = LCA(root.children.get(i), p, q);
			if (node != null && node1 == null)
				node1 = node;
			else if (node != null && node2 == null)
				node2 = node;
		}
		if (node1 != null && node2 != null)
			return root;
		return node1 != null ? node1 : node2;
	}

	public static void main(String[] args) {
		GeneralTreeNode root = new GeneralTreeNode(0);
		GeneralTreeNode A = new GeneralTreeNode(1);
		GeneralTreeNode B = new GeneralTreeNode(2);
		GeneralTreeNode C = new GeneralTreeNode(3);
		GeneralTreeNode D = new GeneralTreeNode(4);
		GeneralTreeNode E = new GeneralTreeNode(5);
		GeneralTreeNode F = new GeneralTreeNode(6);
		GeneralTreeNode G = new GeneralTreeNode(7);
		GeneralTreeNode H = new GeneralTreeNode(8);
		GeneralTreeNode I = new GeneralTreeNode(9);
		GeneralTreeNode J = new GeneralTreeNode(10);
		GeneralTreeNode K = new GeneralTreeNode(11);
		GeneralTreeNode L = new GeneralTreeNode(12);
		GeneralTreeNode M = new GeneralTreeNode(13);
		GeneralTreeNode N = new GeneralTreeNode(14);
		GeneralTreeNode O = new GeneralTreeNode(15);
		root.children.add(A);
		A.children.add(B);
		A.children.add(C);
		A.children.add(D);
		B.children.add(E);
		B.children.add(F);
		B.children.add(G);
		C.children.add(H);
		C.children.add(I);
		C.children.add(J);
		D.children.add(K);
		D.children.add(L);
		D.children.add(M);
		E.children.add(N);
		I.children.add(O);
		LCAofGeneralTree lca = new LCAofGeneralTree();
		System.out.println(lca.LCA(root, N, M).val);
	}

}