package Leetcode_solution;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode547 {

    public static void main(String[] args) {

    }
    class Solution {
        public int findCircleNum(int[][] adj) {
            int n = adj.length;
            boolean[] visited = new boolean[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    bfs(adj, visited, i);
                    count++;
                }
            }
            return count;
        }

        private void bfs(int[][] adj, boolean[] visited, int start) {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int j = 0; j < adj.length; j++) {
                    if (adj[node][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.add(j);
                    }
                }
            }
        }
    }
}
