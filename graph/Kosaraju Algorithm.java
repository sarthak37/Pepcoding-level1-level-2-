import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(kosaraju(graph, n));
	}

	public static int kosaraju(ArrayList<ArrayList<Integer>> list, int N) {
		int count = 0;
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(list, visited, i, stack);
			}
		}
		ArrayList<ArrayList<Integer>> tanspose = transpose(list, N);
		visited = new boolean[N];
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (!visited[cur]) {

				dfs(tanspose, visited, cur);
				count++;
			}
		}

		return count;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur) {
		visited[cur] = true;
		for (Integer neighbour : graph.get(cur)) {
			if (!visited[neighbour]) {
				dfs(graph, visited, neighbour);
			}
		}
	}

	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur, Stack<Integer> stack) {
		visited[cur] = true;
		for (Integer neighbour : graph.get(cur)) {
			if (!visited[neighbour]) {
				dfs(graph, visited, neighbour, stack);
			}
		}
		stack.push(cur);
	}

	public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> graph, int N) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			result.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N; i++) {
			for (Integer target : graph.get(i)) {
				result.get(target).add(i);
			}
		}
		return result;

		}

}