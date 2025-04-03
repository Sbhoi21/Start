package basic;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
	
	public void printPreorder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public void printPostorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.print(root.val + " ");
	}
	
	public void printLevelOrder(TreeNode root) {
		int h = height(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}
	
	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int lheight = height(root.left);
			int rheight = height(root.right);

			if (lheight > rheight) {
				return lheight + 1;
			} else {
				return rheight + 1;
			}
		}
	}
	
	public void printGivenLevel(TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.val + " ");
		} else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}
}