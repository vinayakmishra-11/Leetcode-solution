class Solution {
    public void sortColors(int[] nums) {
        int noz=0;
        int noo=0;
        for(int i=0 ; i< nums.length;i++){
                if(nums[i]==0) noz++;
                else if (nums[i]==1) noo++;
        }
        for(int i=0 ; i< nums.length;i++){
                if(i<noz) nums[i]=0;
                else if (i<noz+noo) nums[i]=1;
                else nums[i]=2;
        }
    }
}
---------------------------------------------------------------------------

// Dutch Flag alog

class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }

            else if (nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
