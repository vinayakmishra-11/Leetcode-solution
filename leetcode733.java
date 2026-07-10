class Pair{
    int row;
    int col;
    Pair(int r , int c){
        this.row = r;
        this.col = c;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] v = new boolean[image.length][image[0].length];
        int op = image[sr][sc];
        Pair p = new Pair(sr,sc);
        int er = image.length-1;
        int ec = image[0].length-1;
        if(image[sr][sc] ==op){
            image[sr][sc] =color;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        v[sr][sc] = true;
        while(!q.isEmpty()){
            Pair pair = q.poll();

            int r = pair.row;
            int c=pair.col;

            if(c>0 && v[r][c-1]==false && image[r][c-1]==op){// going left col dec
                image[r][c-1] = color;
                v[r][c-1] = true;
                q.add(new Pair(r,c-1));                                
           }

            if(c>0 && v[r][c-1]==false && image[r][c-1]==op){// going left col dec
                image[r][c-1] = color;
                v[r][c-1] = true;
                q.add(new Pair(r,c-1));                                
           }

            if(c<ec && v[r][c+1]==false && image[r][c+1]==op){// going right col inc
                image[r][c+1] = color;
                v[r][c+1] = true;
                q.add(new Pair(r,c+1));                                
           }

           if(r>0 && v[r-1][c]==false && image[r-1][c]==op){
            image[r-1][c] =color;
            v[r-1][c] = true;
            q.add(new Pair(r-1,c));
           }

           if(r<er && v[r+1][c]==false && image[r+1][c]==op){
            image[r+1][c] =color;
            v[r+1][c] = true;
            q.add(new Pair(r+1,c));
           }
    }
    return image;
    }
 
}
