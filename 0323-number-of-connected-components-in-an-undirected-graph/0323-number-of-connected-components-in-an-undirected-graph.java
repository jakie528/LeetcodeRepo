class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        // Visited Set
        HashSet<Integer> set = new HashSet<>();
        // Build the graph
        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            ls.add(new ArrayList<>());  // each vertex has a list
        }

        for (int[] edge : edges) {
            ls.get(edge[0]).add(edge[1]);
            ls.get(edge[1]).add(edge[0]);
        }

        // The number of times we start a new DFS will be the number of connected components.
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                components++;
                dfs(i,ls, set);
            }

        }

        return components;
    }

    public void dfs(int i, List<List<Integer>> ls, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        // add other vertex to this component
        visited.add(i);

        for (int neighbor : ls.get(i)) {
            dfs(neighbor,ls, visited);
        }

    }
}