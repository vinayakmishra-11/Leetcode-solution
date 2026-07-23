class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int s =0 ;

        for(int i =0;i<grumpy.length;i++){
            if(grumpy[i]==0) s+=customers[i];
        }
        for(int i =0 ;i <minutes;i++){
            if(grumpy[i]==1) s+=customers[i];
        }

        int max =s;

        for(int i=minutes;i<grumpy.length;i++){
            int left = grumpy[i-minutes];
            int right = grumpy[i];

            if(left==1) s=s-customers[i-minutes];
            if(right==1) s=s+customers[i];

            max=Math.max(s,max);

        }
        return max;
    }
}



