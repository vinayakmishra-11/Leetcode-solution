class Solution {
    public static int NoOnes(String str){
        int count=0;
        for(int i =0 ;i<str.length();i++){
            if(str.charAt(i)=='1') count++;
        }
        return count;
    }

    public static int NoZeros(String str){
        int count=0;
        for(int i =0 ;i<str.length();i++){
            if(str.charAt(i)=='0') count++;
        }
        return count;
    }
    public static int help(String[] strs , int m , int n,int i,int[][][] dp){
        if(i==strs.length) return 0;
       // if(m==0 && n==0) return 1;
       if(dp[m][n][i]!=-1) return dp[m][n][i];
        int take =0 ;
        int skip=help(strs,m,n,i+1,dp);
        
        if(NoZeros(strs[i])<=m && NoOnes(strs[i])<=n){
            take=1+ help(strs,m-NoZeros(strs[i]),n-NoOnes(strs[i]),i+1,dp);
        }else{
             take = help(strs,m,n,i+1,dp);
        }
        
        return dp[m][n][i]=Math.max(take,skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[m+1][n+1][strs.length];

        for(int i =0;i<=m;i++){
            for(int j =0 ;j<=n;j++){
                for(int k =0 ;k<strs.length;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return help(strs,m,n,0,dp);
    }
}