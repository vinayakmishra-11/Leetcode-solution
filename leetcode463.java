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

        Queue<Pair> q = new LinkedList<>();
        v[sr][sc] = true;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){

            Pair pair = q.poll();
            int r = pair.row;
            int c = pair.col;

            // LEFT
            if(c == 0)
                count++;
            else if(grid[r][c-1] == 0)
                count++;
            else if(!v[r][c-1]){
                v[r][c-1] = true;
                q.add(new Pair(r,c-1));
            }

            // RIGHT
            if(c == ec)
                count++;
            else if(grid[r][c+1] == 0)
                count++;
            else if(!v[r][c+1]){
                v[r][c+1] = true;
                q.add(new Pair(r,c+1));
            }

            // UP
            if(r == 0)
                count++;
            else if(grid[r-1][c] == 0)
                count++;
            else if(!v[r-1][c]){
                v[r-1][c] = true;
                q.add(new Pair(r-1,c));
            }

            // DOWN
            if(r == er)
                count++;
            else if(grid[r+1][c] == 0)
                count++;
            else if(!v[r+1][c]){
                v[r+1][c] = true;
                q.add(new Pair(r+1,c));
            }
        }

        return count;
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        boolean[][] v = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !v[i][j]){
                    perimeter += bfs(i, j, v, grid);
                }
            }
        }

        return perimeter;
    }
}