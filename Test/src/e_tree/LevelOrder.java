package e_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a sample binary tree
		Node root = new Node(1);
		root.left = new Node(5);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(2);
		root.right.left = new Node(5);
		root.right.right = new Node(0);

		levelOrder(root);
		System.out.println();
		System.out.println(levelOrder1(root));

	}

	public static void levelOrder(Node root) {
		// TODO Auto-generated method stub

		// Create an empty queue for level order traversal
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.data + " ");
			// Enqueue left child
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			// Enqueue right child
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}

	}

	public static List<List<Integer>> levelOrder1(Node root) {
		// TODO Auto-generated method stub

		// Create an empty queue for level order traversal
		Queue<Node> queue = new ArrayDeque<Node>();

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node tempNode = queue.poll();
				level.add(tempNode.data);
				// Enqueue left child
				if (tempNode.left != null) {
					queue.add(tempNode.left);
				}
				// Enqueue right child
				if (tempNode.right != null) {
					queue.add(tempNode.right);
				}
			}
			result.add(level);
		}
		return result;

	}

	public static List<List<Integer>> levelOrderByRecursion(Node root) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<>();

		levelOrderByRecursionHelper(root, 0, result);
		return result;
		
	}

	public static void levelOrderByRecursionHelper(Node root, int level, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		if (root == null) {
			return;
		}
		if (level == result.size()) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(root.data);
		levelOrderByRecursionHelper(root.left, level + 1, result);
		levelOrderByRecursionHelper(root.right, level + 1, result);
	}
}
