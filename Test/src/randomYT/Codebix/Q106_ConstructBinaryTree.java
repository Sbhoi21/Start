package randomYT.Codebix;

import basic.TreeNode;

public class Q106_ConstructBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		
		TreeNode root = new Q106_ConstructBinaryTree().buildTree(inorder, postorder);
		root.printLevelOrder(root);
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}
	
	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		TreeNode root = new TreeNode(postorder[postEnd]);
		int inIndex = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				inIndex = i;
				break;
			}
		}

		root.left = buildTree(inorder, inStart, inIndex - 1, postorder, postStart, postStart + inIndex - inStart - 1);
		root.right = buildTree(inorder, inIndex + 1, inEnd, postorder, postStart + inIndex - inStart, postEnd - 1);

		return root;
	}

}
