

import java.util.*;
public class leetcode743 {
}
class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int u = times[i][0] - 1;
            int v = times[i][1] - 1;
            int w = times[i][2];

            list.get(u).add(new Pair(v, w));
        }
        int[] result = diks(n,list,k-1);
        int ans = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, result[i]);
        }
        return ans;

    }
    public static int[] diks(int n,ArrayList<ArrayList<Pair>> list,int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();
            int curr = current.node;
            int d = current.dist;
            for(Pair neh : list.get(curr)){
                int nnn = neh.node;
                int w = neh.dist;

                if(dist[curr]+w < dist[nnn]){
                    dist[nnn] = dist[curr] + w;
                    pq.add(new Pair(nnn,dist[nnn]));
                }
            }
        }
        return dist;

    }
}
