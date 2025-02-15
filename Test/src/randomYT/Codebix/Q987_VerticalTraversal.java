package randomYT.Codebix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import basic.TreeNode;

public class Q987_VerticalTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		List<List<Integer>> res = verticalTraversal(root);
		for (List<Integer> l : res) {
			System.out.println(l);
		}
	}

	static Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		dfs(root, 0, 0);
		List<List<Integer>> res = new ArrayList<>();
		for (int key : map.keySet()) {
			List<Integer> list = new ArrayList<>();
			ArrayList<int[]> temp = map.get(key);
			temp.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
			for (int[] arr : temp) {
				list.add(arr[1]);
			}
			res.add(list);
		}
		return res;
	}

	static void dfs(TreeNode root, int index, int dept) {
		if (root == null) {
			return;
		}
		map.putIfAbsent(index, new ArrayList<>());
		map.get(index).add(new int[] { dept, root.val });
		dfs(root.left, index - 1, dept + 1);
		dfs(root.right, index + 1, dept + 1);
	}

}
