class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int i =0 ;
        int j =1 ;
        arr[0]=1;
        int max = Integer.MIN_VALUE;
        while(j<arr.length){
            int a = arr[i];
            int b =arr[j];
            if(b>a+1){
                b=a+1;
                arr[j] = b;
            }
            i++;
            j++;
        }
       
        return arr[arr.length-1];
    }
}