class Solution {

    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        long[] prefixSum = new long[n + 1];
        long[] prefixNum = new long[n + 1];
        long[] pow10 = new long[n + 1];
        int[] nonZero = new int[n + 1];

        pow10[0] = 1;

        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        for (int i = 0; i < n; i++) {

            prefixSum[i + 1] = prefixSum[i];
            prefixNum[i + 1] = prefixNum[i];
            nonZero[i + 1] = nonZero[i];

            int d = s.charAt(i) - '0';

            if (d != 0) {
                prefixSum[i + 1] += d;
                prefixNum[i + 1] = (prefixNum[i] * 10 + d) % MOD;
                nonZero[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            long sum = prefixSum[r + 1] - prefixSum[l];

            int digits = nonZero[r + 1] - nonZero[l];

            long left = prefixNum[l];
            long right = prefixNum[r + 1];

            long num =
                    (right - (left * pow10[digits]) % MOD + MOD) % MOD;

            ans[i] = (int) ((sum % MOD) * num % MOD);
        }

        return ans;
    }
}