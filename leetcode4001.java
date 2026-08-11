class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {

        int[][] ferilonsar = { { series1.length }, { series2.length } };

        List<List<Integer>> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < series1.length || j < series2.length) {

            int t1;
            if (i < series1.length) {
                t1 = series1[i][0];
            } else {
                t1 = Integer.MAX_VALUE;
            }

            int t2;
            if (j < series2.length) {
                t2 = series2[j][0];
            } else {
                t2 = Integer.MAX_VALUE;
            }

            int time = Math.min(t1, t2);

            int val1;
            if (i < series1.length) {
                val1 = series1[i][1];
            } else {
                val1 = 0;
            }

            int val2;
            if (j < series2.length) {
                val2 = series2[j][1];
            } else {
                val2 = 0;
            }

            ans.add(Arrays.asList(time, val1 + val2));

            if (i < series1.length && series1[i][0] == time) {
                i++;
            }

            if (j < series2.length && series2[j][0] == time) {
                j++;
            }
        }

        return ans;
    }
}