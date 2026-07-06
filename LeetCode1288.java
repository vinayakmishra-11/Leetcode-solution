class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 0;
        int n =intervals.length;
        boolean[] check = new boolean[n];
        for(int i=0;i<n;i++){
              int[] arrA = intervals[i];
            for(int j=0;j<n;j++){
              int[] arrB = intervals[j];
             if(arrA==arrB) continue;
              int a = arrA[0];
              int b = arrA[1];
              int c = arrB[0];
              int d = arrB[1];

              if(c<= a && b<=d && check[i]!=true) {
                ans++;
                check[i] = true;
              }
            }
        }
        return n-ans ;
    }
}