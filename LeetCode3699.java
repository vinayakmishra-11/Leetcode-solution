class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;

        int m = r - l + 1;

        long[][] up = new long[n + 1][m + 1];
        long[][] down = new long[n + 1][m + 1];

        for (int v = 1; v <= m; v++) {
            up[1][v] = 1;
            down[1][v] = 1;
        }

        for (int len = 2; len <= n; len++) {

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int v = 1; v <= m; v++) {
                prefUp[v] = (prefUp[v - 1] + up[len - 1][v]) % MOD;
                prefDown[v] = (prefDown[v - 1] + down[len - 1][v]) % MOD;
            }

            for (int v = 1; v <= m; v++) {

                // last step is UP
                up[len][v] = prefDown[v - 1];

                // last step is DOWN
                down[len][v] =
                    (prefUp[m] - prefUp[v] + MOD) % MOD;
            }
        }

        long ans = 0;

        for (int v = 1; v <= m; v++) {
            ans = (ans + up[n][v] + down[n][v]) % MOD;
        }

        if (n == 1) {
            return m;
        }

        return (int) ans;
    }
}