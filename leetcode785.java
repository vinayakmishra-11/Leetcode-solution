package Leetcode_solution;
import java.util.*;
public class leetcode785 {
    public static void main(String[] args) {

    }
    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            for(int i =0 ;i<n ;i++){
                if(color[i]!=0) continue ;
                Queue<Integer> q = new LinkedList<>();

                q.add(i);

                color[i]=1;
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int nei : graph[curr]){
                        if(color[nei]==0){
                            color[nei] = -color[curr];
                            q.add(nei);
                        }
                        else if (color[nei] == color[curr]){
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }















}
