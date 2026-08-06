class Solution {
    private List<Integer>[] graph;      // Directed graph
    private List<Integer>[] undirected; // Undirected graph
    private boolean[] suspicious;       // Suspicious methods
    private boolean[] visited;          // DFS visited

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        graph = new ArrayList[n];
        undirected = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            undirected[i] = new ArrayList<>();
        }

        // Build graphs
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);          // Original direction
            undirected[u].add(v);     // Undirected edge
            undirected[v].add(u);
        }

        suspicious = new boolean[n];
        visited = new boolean[n];

        // Mark all methods reachable from k
        markSuspicious(k);

        // Any suspicious node connected to a non-suspicious node
        // cannot be removed.
        for (int i = 0; i < n; i++) {
            if (!suspicious[i] && !visited[i]) {
                restore(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void markSuspicious(int node) {
        suspicious[node] = true;

        for (int next : graph[node]) {
            if (!suspicious[next]) {
                markSuspicious(next);
            }
        }
    }

    private void restore(int node) {
        visited[node] = true;
        suspicious[node] = false;

        for (int next : undirected[node]) {
            if (!visited[next]) {
                restore(next);
            }
        }
    }
}