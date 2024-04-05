package e_tree;

public class DFS {

	
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
