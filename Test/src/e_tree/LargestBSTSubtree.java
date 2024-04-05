package e_tree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LargestBSTSubtree {
	static int maxSubtreeSize;

	public static int largestBSTSubtree(TreeNode root) {
		maxSubtreeSize = 0;
		isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return maxSubtreeSize;
	}

	private static int isBST(TreeNode root, int min, int max) {
		if (root == null)
			return 0;
		System.out.println(root.val + "  " + min + "  " + max);
		if (root.val <= min || root.val >= max) {
			// Not a BST, reset subtree size to 0 and return
			isBST(root.left, Integer.MIN_VALUE, Integer.MAX_VALUE);
			isBST(root.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
			return 0;
		}

		int leftSize = isBST(root.left, min, root.val);
		System.out.println("leftSize: " + leftSize + "  root.val: " + root.val + "  min: " + min + "  max: " + max);
		int rightSize = isBST(root.right, root.val, max);
		System.out.println("rightSize: " + rightSize + "  root.val: " + root.val + "  min: " + min + "  max: " + max);
		if (leftSize == -1 || rightSize == -1) {
			// Subtree is not a BST, reset subtree size to 0 and return
			isBST(root.left, Integer.MIN_VALUE, Integer.MAX_VALUE);
			isBST(root.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
			return 0;
		}

		// Subtree rooted at current node is a BST
		int subtreeSize = leftSize + rightSize + 1;
		System.out.println("subtreeSize: " + subtreeSize + "  root.val: " + root.val + "  min: " + min + "  max: " + max + "  leftSize: " + leftSize + "  rightSize: " + rightSize);
		maxSubtreeSize = Math.max(maxSubtreeSize, subtreeSize);

		return subtreeSize;
	}

	// Sample Usage
	public static void main(String[] args) {
		// Create the binary tree
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right.right = new TreeNode(7);

		System.out.println(largestBSTSubtree(root)); // Output: 3
	}

}
