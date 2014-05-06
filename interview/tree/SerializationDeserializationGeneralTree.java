package tree;

import java.util.StringTokenizer;

/*
 * Use DFS to serialize a tree, val + # of children
 * */
public class SerializationDeserializationGeneralTree {
	private String res;

	public String serialize(GeneralTreeNode root) {
		this.res = "";
		return _serialize_(root);
	}

	private String _serialize_(GeneralTreeNode root) {
		if (root == null)
			return "";
		int n = root.children.size();
		res += root.val + " " + n + " ";
		for (int i = 0; i < n; ++i) {
			_serialize_(root.children.get(i));
		}
		return res;
	}

	public GeneralTreeNode deserialize(String str) {
		StringTokenizer st = new StringTokenizer(str);
		return deserialize(st);
	}

	private GeneralTreeNode deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens())
			return null;
		int val = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		GeneralTreeNode root = new GeneralTreeNode(val);
		for (int i = 0; i < num; ++i) {
			root.children.add(deserialize(st));
		}
		return root;
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
		SerializationDeserializationGeneralTree s = new SerializationDeserializationGeneralTree();
		String serialization = s.serialize(root);
		System.out.println(serialization);
		GeneralTreeNode deroot = s.deserialize(serialization);
		String ret = s.serialize(deroot);
		System.out.println(ret);
	}
}
