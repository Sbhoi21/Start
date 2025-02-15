package randomYT.Codebix;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] graph = { { 1, 2 }, { 2 }, { 3 }, { 3 }, {} };
		System.out.println(new DetectCycleInDirectedGraph().hasCycle(graph));
		
		int[][] graph2 = { { 1, 2 }, { 2 }, { 3 }, { 4 }, { 1 }  };
		System.out.println(new DetectCycleInDirectedGraph().hasCycle(graph2));
	}
	
	public boolean hasCycle(int[][] graph) {
		int n = graph.length;
		boolean[] visited = new boolean[n];
		boolean[] recStack = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (dfs(graph, i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	boolean dfs(int[][] graph, int u, boolean[] visited, boolean[] recStack) {
		if (recStack[u]) {
			return true;
		}
		if (visited[u]) {
			return false;
		}
		visited[u] = true;
		recStack[u] = true;
		for (int v : graph[u]) {
			if (dfs(graph, v, visited, recStack)) {
				return true;
			}
		}
		recStack[u] = false;
		return false;
	}

}
