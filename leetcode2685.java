
class Solution {
    public static boolean bfs(int i , boolean[] v ,ArrayList<ArrayList<Integer>> list){
       
        Queue<Integer> q = new LinkedList<>();
        int edges =0 ;
        int Nodes =0;
        q.add(i);
        v[i] = true;
        while(!q.isEmpty()){
            
            int node = q.poll();
            Nodes++;
            for(int neh : list.get(node)){
                edges++;
                if(!v[neh]){
                    v[neh] = true;
                    q.add(neh);
                }
            }
        }
        edges = edges/2;

        if(edges ==( Nodes*(Nodes-1))/2){
            return true;
        }
        return false ;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
    int u = edge[0];
    int v = edge[1];

    list.get(u).add(v);
    list.get(v).add(u);
}
        boolean[] v = new boolean[n];

        boolean ans = false;
        int count =0;
        for(int i =0 ;i<n;i++){
            if(!v[i]){
                if(bfs(i,v,list)){
                    count++;
                }
            }
        }
        return count;

    }
}