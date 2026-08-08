class Solution {
     public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickselect(int[] arr, int low, int high, int target) {

        if (low >= high)
            return;

        int[] range = partition(arr, low, high);

        int left = range[0];
        int right = range[1];

        if (target < left) {
            quickselect(arr, low, left - 1, target);
        }
        else if (target > right) {
            quickselect(arr, right + 1, high, target);
        }
        // target is between left and right
        // Therefore arr[target] is already the answer
    }

    public static int[] partition(int[] arr, int low, int high) {

        int pivot = arr[low];

        int i = low;
        int j = low;
        int k = high;

        while (j <= k) {

            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
                j++;
            }

            else if (arr[j] > pivot) {
                swap(arr, j, k);
                k--;
            }

            else {
                j++;
            }
        }

        // [low ... i-1]     < pivot
        // [i ... k]         == pivot
        // [k+1 ... high]    > pivot

        return new int[]{i, k};
    }
    public int findKthLargest(int[] arr, int k) {
         int target = arr.length - k;
         quickselect(arr, 0, arr.length - 1, target);
         return arr[target];
    }
}