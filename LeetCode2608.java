class Pair{
    int parent;
    int node;

    Pair(int n, int p){
        this.node = n;
        this.parent = p;
    }
}

class Solution {

    public static int bfs(int start, ArrayList<ArrayList<Integer>> list){

        Queue<Pair> q = new LinkedList<>();

        int[] dist = new int[list.size()];
        Arrays.fill(dist, -1);

        q.add(new Pair(start, -1));
        dist[start] = 0;

        int ans = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Pair p = q.poll();

            int node = p.node;
            int parent = p.parent;

            for(int neh : list.get(node)){

                if(dist[neh] == -1){

                    dist[neh] = dist[node] + 1;
                    q.add(new Pair(neh, node));

                }
                else if(neh != parent){

                    ans = Math.min(ans,
                            dist[node] + dist[neh] + 1);
                }
            }
        }

        return ans;
    }

    public int findShortestCycle(int n, int[][] edges) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            ans = Math.min(ans, bfs(i, list));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}