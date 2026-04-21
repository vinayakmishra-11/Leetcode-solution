class Solution {
     public static void even(int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);
}






    public static void odd(int[] arr, int k) {
    int n = arr.length;
    k = k % n;

    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
}

public static void reverse(int[] arr, int l, int r) {
    while (l < r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        l++;
        r--;
    }
}
    public boolean areSimilar(int[][] mat, int k) {
        int[][] temp = new int[mat.length][mat[0].length];
        for(int i =0;i<mat.length;i++){
            for(int j =0 ;j<mat[0].length;j++){
                temp[i][j] = mat[i][j];
            }
        }

        for(int i =0;i<mat.length;i++){
            
            if(i%2==0) even(temp[i],k);
            else odd(temp[i],k);
        }
            for(int i =0;i<mat.length;i++){
            for(int j =0 ;j<mat[0].length;j++){
                if(temp[i][j]!=mat[i][j]) return false;
            }
        }

        return true;
    }
}