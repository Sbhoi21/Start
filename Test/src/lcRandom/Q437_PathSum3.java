package lcRandom;

import java.util.HashMap;
import java.util.Map;

import basic.TreeNode;

public class Q437_PathSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);

		int sum = 8;
//		System.out.println(new Q437_PathSum3().pathSum(root, sum));

		// [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]

		TreeNode root1 = new TreeNode(1000000000);
		root1.left = new TreeNode(1000000000);
		root1.left.left = new TreeNode(294967296);
		root1.left.left.left = new TreeNode(1000000000);
		root1.left.left.left.left = new TreeNode(1000000000);
		root1.left.left.left.left.left = new TreeNode(1000000000);
		sum = 0;
		System.out.println(new Q437_PathSum3().pathSum3(root1, sum));
		System.out.println(new Q437_PathSum3().pathSum1(root1, sum));
	}

	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	private int pathSumFrom(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		return (node.val == sum ? 1 : 0) + pathSumFrom(node.left, sum - node.val)
				+ pathSumFrom(node.right, sum - node.val);
	}

	// O(n) time complexity using HashMap
	public int pathSum1(TreeNode root, int sum) {
		Map<Long, Integer> map = new HashMap<>();
		map.put((long) 0, 1);
		return backtrack(root, 0, sum, map);
	}

	private int backtrack(TreeNode node, long sum, int target, Map<Long, Integer> map) {
		if (node == null) {
			return 0;
		}

		sum += node.val;
		System.out.println(" sum: " + sum + " node: " + node.val);
		int res = map.getOrDefault(sum - target, 0);
		System.out.println("res: " + res + " sum: " + sum + " target: " + target + "node: " + node.val);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		res += backtrack(node.left, sum, target, map) + backtrack(node.right, sum, target, map);
		map.put(sum, map.get(sum) - 1);
		return res;
	}

	public int pathSum3(TreeNode root, int targetSum) {
		Map<Long, Integer> hmap = new HashMap<>();
		int count = 0;

		dfs(root, 0, targetSum, hmap, count);

		return count;
	}

	private void dfs(TreeNode root, long prefixSum, int targetSum, Map<Long, Integer> hmap, int count) {
		if (root == null)
			return;

		prefixSum += root.val;

		if (hmap.containsKey(prefixSum - targetSum))
			count += hmap.get(prefixSum - targetSum);

		if (targetSum == prefixSum)
			count++;
		System.out.println("res: " + count + " sum: " + prefixSum + " target: " + targetSum);
		hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);

		dfs(root.left, prefixSum, targetSum, hmap, count);
		dfs(root.right, prefixSum, targetSum, hmap, count);

		hmap.put(prefixSum, hmap.get(prefixSum) - 1);
	}

}
