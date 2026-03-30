class Pair {
    int node;
    int weight;
    int parent;

    Pair(int node, int weight, int parent) {
        this.node = node;
        this.weight = weight;
        this.parent = parent;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int i =0;i<points.length;i++){
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < points.length; i++) {
    for (int j = i + 1; j < points.length; j++) {

        int xi = points[i][0];
        int yi = points[i][1];

        int xj = points[j][0];
        int yj = points[j][1];

        int cost = Math.abs(xi - xj) + Math.abs(yi - yj);

        // undirected graph
        list.get(i).add(new Pair(j, cost, i));
        list.get(j).add(new Pair(i, cost, j));
    }
}
        int n = points.length;
        boolean[] v = new boolean[n];
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.weight-b.weight
        );
        pq.add(new Pair(0,0,-1));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currWeight = curr.weight;
            int currparent = curr.parent;
        if(v[currNode]) continue;

            if( currparent!=-1){
                sum=sum+currWeight;
            }
            
            v[currNode] =true;
            for(Pair neh : list.get(currNode)){
                if(!v[neh.node]){
                    pq.add(new Pair(neh.node, neh.weight, currNode));
                }
            }

        }
        return sum;
    
    }
}