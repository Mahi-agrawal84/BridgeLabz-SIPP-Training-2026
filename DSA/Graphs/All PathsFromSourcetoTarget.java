import java.util.*;

class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);

        dfs(graph, 0, path, ans);

        return ans;
    }

    private void dfs(int[][] graph, int node,
                     List<Integer> path,
                     List<List<Integer>> ans) {

        // Reached destination
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Explore all neighbors
        for (int neighbor : graph[node]) {

            path.add(neighbor);

            dfs(graph, neighbor, path, ans);

            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}
