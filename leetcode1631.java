
import java.util.*;
public class leetcode1631 {
}
class Pair {
    int i;
    int j;
    int dist;

    Pair(int i,int j, int dist) {
        this.i = i;
        this.j=j;
        this.dist = dist;
    }
}

class Solution {
    public int minimumEffortPath(int[][] arr) {

        int row = arr.length;
        int col = arr[0].length;

        int[][] ans = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        ans[0][0] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a,b) -> Integer.compare(a.dist , b.dist));

        pq.add(new Pair(0,0,0));

        // ⭐ direction optimisation
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        while(!pq.isEmpty()){

            Pair p = pq.poll();
            int i = p.i;
            int j = p.j;
            int dist = p.dist;

            if(dist > ans[i][j]) continue;

            // ⭐ early stop optimisation
            if(i == row - 1 && j == col - 1)
                return dist;

            // ⭐ single loop instead of 4 blocks
            for(int k = 0; k < 4; k++){

                int ni = i + di[k];
                int nj = j + dj[k];

                if(ni >= 0 && nj >= 0 && ni < row && nj < col){

                    int newEffort = Math.max(
                            dist,
                            Math.abs(arr[i][j] - arr[ni][nj])
                    );

                    if(newEffort < ans[ni][nj]){
                        ans[ni][nj] = newEffort;
                        pq.add(new Pair(ni , nj , newEffort));
                    }
                }
            }
        }

        return ans[row-1][col-1];
    }
}