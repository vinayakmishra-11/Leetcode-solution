



class Pair{
    int row;
    int col;
    Pair(int r , int c){
        this.row = r;
        this.col = c;
    }
}

class Solution {

    public static int bfs(int sr,int sc,boolean[][] v , int[][] grid){
        int count = 0;
        int er = grid.length - 1;
        int ec = grid[0].length - 1;
        count++;
        Queue<Pair> q = new LinkedList<>();
        v[sr][sc] = true;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){

            Pair pair = q.poll();
            int r = pair.row;
            int c = pair.col;

            // LEFT
        
             if( c>0 && !v[r][c-1] && grid[r][c-1]==1){
                count++;
                v[r][c-1] = true;
                q.add(new Pair(r,c-1));
            }

            // RIGHT
            
             if( c<ec && !v[r][c+1] && grid[r][c+1]==1){
                count++;
                v[r][c+1] = true;
                q.add(new Pair(r,c+1));
            }

            // UP
          
             if( r>0 && !v[r-1][c] && grid[r-1][c]==1){
                count++;
                v[r-1][c] = true;
                q.add(new Pair(r-1,c));
            }

            // DOWN
        
             if( r<er && !v[r+1][c] && grid[r+1][c]==1){
                count++;
                v[r+1][c] = true;
                q.add(new Pair(r+1,c));
            }
        }

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int perimeter = 0;
        boolean[][] v = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !v[i][j]){
                    perimeter = Math.max(bfs(i, j, v, grid),perimeter);
                }
            }
        }

        return perimeter;
    }
}