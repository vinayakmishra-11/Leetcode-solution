class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<nums.length;i++){
            pq.add(nums[i]);
        }
     
        for(int i = 0 ; i<k;i++){
            int x = pq.poll();
            x=-1*x;
            pq.add(x);
        }

        int sum =0 ; 

        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
       

        return sum;
    }
}