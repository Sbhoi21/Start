package randomYT.Codebix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import basic.TreeNode;

public class Q987_VerticalTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
	public List<List<Integer>> verticalTraversal(TreeNode root) {

		return null;
	}

	void dfs(TreeNode root, int index, int dept) {
		if (root == null) {
			return;
		}
		map.putIfAbsent(index, new ArrayList<>());
		map.get(index).add(new int[] { dept, root.val });
		dfs(root.left, index - 1, dept + 1);
		dfs(root.right, index + 1, dept + 1);
	}

}
