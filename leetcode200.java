 class Pair{
        int row;
        int col;
         Pair(int row , int col){
            this.row=row;
            this.col=col;
        }
    }
class Solution {
     
    public static void bfs(int r , int c , char[][] grid, boolean[][] visited) {
        Pair p = new Pair(r,c);
        Queue<Pair> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(p);
        int nr = grid.length;
        int nc = grid[0].length;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int sr = pair.row;
            int sc = pair.col;

            if(sc>0 &&  visited[sr][sc-1]==false && grid[sr][sc-1]=='1'){ //going left column decresing
                q.add(new Pair(sr,sc-1));
                visited[sr][sc-1] = true;
            } 

            if(sc<nc-1 &&   visited[sr][sc+1]==false && grid[sr][sc+1]=='1'){ //going right column inc
                q.add(new Pair(sr,sc+1));
                visited[sr][sc+1] = true;
            } 

             if(sr>0 &&   visited[sr-1][sc]==false && grid[sr-1][sc]=='1'){ //going up row dec
                q.add(new Pair(sr-1,sc));
                visited[sr-1][sc] = true;
            } 

             if(sr<nr-1 &&   visited[sr+1][sc]==false && grid[sr+1][sc]=='1'){ //going down row inc
                q.add(new Pair(sr+1,sc));
                visited[sr+1][sc] = true;
            } 


        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count =0;
        for(int i =0 ;i<grid.length;i++){
            for(int j =0 ;j<grid[0].length;j++){
               if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
            
        }
        return count;
    }
}