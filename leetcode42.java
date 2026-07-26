class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int maxleft = height[0];
        left[0] = height[0];
        for (int i = 1; i < left.length; i++) {
            if (height[i] > left[i - 1]) {
                left[i] = height[i];
            } else
                left[i] = left[i - 1];
        }
    right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            if (height[i] > right[i + 1]) {
                right[i] = height[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        
        int total=0;

        for(int i =0 ;i<left.length;i++){
            total+= Math.min(left[i],right[i]) - height[i];
        }

        return total;
    }
}