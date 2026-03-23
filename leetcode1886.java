package Leetcode_solution;

public class leetcode1886 {
}
class Solution {

    public boolean findRotation(int[][] mat, int[][] target) {

        for (int k = 0; k < 4; k++) {

            if (isEqual(mat, target)) return true;

            rotate90(mat);
        }

        return false;
    }

    private void rotate90(int[][] mat) {

        int n = mat.length;

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // reverse rows
        for (int i = 0; i < n; i++) {

            int l = 0, r = n - 1;

            while (l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
    }

    private boolean isEqual(int[][] a, int[][] b) {

        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (a[i][j] != b[i][j]) return false;
            }
        }

        return true;
    }
}