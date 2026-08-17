class Solution {
    public static void help(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int i =0 ;
        int j =nums.length-1;

        while(i<j){
            if(nums[i]%2==0) i++;
            else if(nums[i]%2!=0){
                help(nums,i,j);
                j--;
            }
        }
        return nums;
    }
}

