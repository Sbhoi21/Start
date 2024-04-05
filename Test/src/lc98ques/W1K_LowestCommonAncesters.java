package lc98ques;

public class W1K_LowestCommonAncesters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//		According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//		Example 1:
//		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//		Output: 6
//		Explanation: The LCA of nodes 2 and 8 is 6.
//
//		Example 2:
//		Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//		Output: 2
//		Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
//
//		Example 3:
//		Input: root = [2,1], p = 2, q = 1
//		Output: 2

		TreeNode myTree = new TreeNode(6);
		myTree.left = new TreeNode(2);
		myTree.right = new TreeNode(8);
		myTree.left.left = new TreeNode(0);
		myTree.left.right = new TreeNode(4);
		myTree.right.left = new TreeNode(7);
		myTree.right.right = new TreeNode(9);
		myTree.left.right.left = new TreeNode(3);
		myTree.left.right.right = new TreeNode(5);

		lowestCommonAncestor(myTree, new TreeNode(2), new TreeNode(5));

	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return new TreeNode();
	}

}
