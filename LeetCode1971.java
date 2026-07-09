class Solution {
    public static void bfs(int start , boolean[] visited ,  List<List<Integer>> graph){
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int key : graph.get(node)){
                if(visited[key]==false){
                    q.add(key);
                    visited[key] = true;
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];

                graph.get(u).add(v);
                graph.get(v).add(u);   // Undirected graph
            }
         bfs(source,visited,graph);

         return visited[destination];
    }
}