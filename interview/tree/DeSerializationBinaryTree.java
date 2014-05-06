package tree;

/*
 * Serialize and deserialize a binary tree.
 * Serialization: print the root's value, then DFS, if it is null, print #
 * Deserialization: Use a pointer to point to the next node
 *                  When encounter with #, just return null
 * */
public class DeSerializationBinaryTree {
	public static String serialize(Node root) {
		if (root == null)
			return "# ";
		else {
			return root.val + " " + serialize(root.left)
					+ serialize(root.right);
		}
	}

	public static Node deserialize(String res) {
		String[] tokens = res.trim().split("\\s+");
		return deserialize(tokens);
	}

	static int index = 0;

	private static Node deserialize(String[] stringArray) {
		if (stringArray[index].equals("#")) {
			index++;
			return null;
		}

		int value = Integer.parseInt(stringArray[index]);
		Node tree = new Node(value);
		index++;
		tree.left = deserialize(stringArray);
		tree.right = deserialize(stringArray);
		return tree;
	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		Node root = new Node(30);
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(50);
		Node node4 = new Node(45);
		Node node5 = new Node(35);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;

		System.out.println(serialize(root));
		// 30 10 50 # # # 20 45 # # 35 # #
		Node node = deserialize("1 2 4 # 6 # # # 3 5 # # #");
		inorder(node);
	}
}
