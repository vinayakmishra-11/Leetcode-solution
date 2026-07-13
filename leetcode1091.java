class Pair{
    int row;
    int col;
    int dist;
    Pair(int r , int c,int d){
        this.row = r;
        this.col= c;
        this.dist=d;
    }
}
class Solution {
    public static int bfs (int row , int col , int[][] grid , boolean[][] v){
        if(grid[row][col]==1 || grid[grid.length-1][grid.length-1]==1) return -1;
        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {1,1},
            {-1,-1},
            {1,-1},
            {-1,1}
        };
        int Distance =0;
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row,col,1));
            Distance = Distance + 1;
            v[row][col] = true;

            while(!q.isEmpty()){
                Pair p =q.poll();
                int r = p.row;
                int c =p.col;
                int d = p.dist;
                Distance = Distance + d;
                if(r==grid.length -1 && c==grid.length-1) return d ;

                for(int[] arr :dir){
                    int newRow = r+arr[0];
                    int newCol = c+arr[1];

                    if(newRow<grid.length && newRow>=0 && newCol>=0 && newCol<grid.length && grid[newRow][newCol]==0 && !v[newRow][newCol]){
                        q.add(new Pair(newRow,newCol,d+1));
                        v[newRow][newCol] = true;
                        
                    }
                }

                
            }
            return Distance;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        int ans =0;
        ans = ans+bfs(0,0,grid,v);    
        if(v[grid.length-1][grid.length-1]==false) return -1;
        return ans;   
        }

    }






 