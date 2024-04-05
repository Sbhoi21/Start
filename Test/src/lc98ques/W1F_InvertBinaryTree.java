package lc98ques;

public class W1F_InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode t = new TreeNode(2);
		t.left = new TreeNode(1);
		t.right = new TreeNode(3);

		TreeNode myTree = new TreeNode(1);
		myTree.left = new TreeNode(2);
		myTree.right = new TreeNode(3);
		myTree.left.left = new TreeNode(4);
		myTree.left.right = new TreeNode(5);
		myTree.right.left = new TreeNode(6);
		myTree.right.right = new TreeNode(7);

		printPreOrder(myTree);
		System.out.println();
		TreeNode tr = invertTree(myTree);

		printPreOrder(tr);
	}

	public static TreeNode invertTree1(TreeNode root) {
		TreeNode t = new TreeNode();
		t.val = root.val;

		while (root.left.left != null) {
			root = root.left;
			t.right = root.left;
		}
		while (root.left.right != null) {
		}

		return t;
	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.right);
		invertTree(root.left);
		return root;
	}

	public static TreeNode invertTreeC(TreeNode root) {
//		return if node ends
		if (root == null) {
			return null;
		}
//		swap left and right nodes
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

//		doing same for children (swapping)
		invertTree(root.right);
		invertTree(root.left);
		return root;
	}

	public static void printPreOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		// Print the current node's data
		System.out.print(root.val + " ");
		// Traverse the left subtree
		printPreOrder(root.left);
		// Traverse the right subtree
		printPreOrder(root.right);
	}

}

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}