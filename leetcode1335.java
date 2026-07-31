class Solution {
    public static int solve(int[] jd, int n, int d, int idx, int[][] dp) {
        if (d == 1) {
            int maxD = Integer.MIN_VALUE;
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jd[i]);
            }
            return dp[idx][d] = maxD;
        }
        if (dp[idx][d] != -1)
            return dp[idx][d];
        int maxD = jd[idx];
        int finalResult = Integer.MAX_VALUE;
        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);

            int result = maxD + solve(jd, n, d - 1, i + 1, dp);
            
            finalResult = Math.min(finalResult, result);
        }
        dp[idx][d] = finalResult;
        return dp[idx][d];
        //return dp[idx][d];
    }

    public int minDifficulty(int[] jd, int d) {
        if (d > jd.length)
            return -1;
        int[][] dp = new int[jd.length][d + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int n = jd.length;
        return solve(jd, n, d, 0, dp);
    }
}