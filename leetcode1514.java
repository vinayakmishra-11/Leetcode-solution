import java.util.*;
import java.util.*;
public class leetcode1514 {
}
class Pair {
    int node;
    double dist;

    Pair(int node, double dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int first = edges[i][0];
            int second = edges[i][1];
            list.get(first).add(new Pair(second,succProb[i]));
            list.get(second).add(new Pair(first,succProb[i]));
        }
        double[] result= diks(list, n,start_node,end_node);
        return result[end_node];
    }
    public static double[] diks(ArrayList<ArrayList<Pair>> list,int n , int start,int end){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist, a.dist));
        double[] dist = new double[n];
        dist[start] =1 ;
        pq.add(new Pair(start,1));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int curr = p.node;
            double prob = p.dist;
            if(curr==end){
                return dist;
            }
            for(Pair neh :list.get(curr)){
                int dest = neh.node;
                double weight = neh.dist;
                if(dist[curr] *weight > dist[dest]){
                    dist[dest]= dist[curr] * weight;
                    pq.add(new Pair(dest,dist[dest]));
                }
            }
        }
        return dist;
    }
}
