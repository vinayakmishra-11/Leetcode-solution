class Solution {
    public static int Overlap(int[][] arr1 , int[][] arr2 , int row , int col){
        int count =0;
        for(int i =0 ;i<arr1.length;i++){
            for(int j =0 ;j<arr1.length;j++){
                if((i+row<0 || j+col<0) || (i+row>=arr1.length || j+col>=arr1.length)) continue;
                else{
                    if(arr1[i][j]==1 && arr2[i+row][j+col]==1 ) count++;
                }
            }
        }
        return count;
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int ans =0;
        for(int row_off = -n+1 ; row_off<n;row_off++){
            for(int col_off = -n+1 ; col_off<n;col_off++){
                ans  = Math.max(ans,Overlap(img1,img2,row_off,col_off));
            }
        }
        return ans;
    }
}
