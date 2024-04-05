package e_tree;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {
	Node root;

	// Constructor
	BinaryTree() {
		root = null;
	}

	// Depth-First Search (Inorder Traversal)
	void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
	}

	// Depth-First Search (Preorder Traversal)
	void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// Depth-First Search (Postorder Traversal)
	void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void main(String[] args) {
		// Create a sample binary tree
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.print("Inorder Traversal: ");
		tree.inOrderTraversal(tree.root);

		System.out.print("\nPreorder Traversal: ");
		tree.preOrderTraversal(tree.root);

		System.out.print("\nPostorder Traversal: ");
		tree.postOrderTraversal(tree.root);
	}
}
