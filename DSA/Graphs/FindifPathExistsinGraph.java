import java.util.*;

public class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Step 1: Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Add edges
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Step 3: DFS
        boolean[] visited = new boolean[n];

        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int node, int destination) {

        if (node == destination)
            return true;

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, destination))
                    return true;
            }
        }

        return false;
    }

    // Main method for VS Code
    public static void main(String[] args) {

        Solution obj = new Solution();

        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        int source = 0;
        int destination = 2;

        System.out.println(obj.validPath(n, edges, source, destination));
    }
}
