class Solution {
    public static void bfs(int start ,List<List<Integer>> rooms,boolean[] ans ){
        ans[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int key  : rooms.get(node)){
                
                   if(!ans[key]){
                    q.add(key);
                    ans[key] = true;
                   }
                
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] ans = new boolean[rooms.size()];
        int n = rooms.size();
        
                bfs(0,rooms,ans);
           
        for(int i =0 ;i<ans.length;i++){
            if(ans[i]==false) return false;
        }
        return true;
    }
}