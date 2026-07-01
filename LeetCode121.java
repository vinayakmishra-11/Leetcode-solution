class Solution {
    public int maxProfit(int[] prices) {
        int MinPrice =prices[0] ;
        int maxProfit =0 ;

        for(int i =1 ;i<prices.length;i++){
            if(MinPrice>prices[i]){
                MinPrice=prices[i];
            }
            else if (prices[i]>MinPrice){
                int p = prices[i] - MinPrice;
                maxProfit=Math.max(p,maxProfit);
            }
        }
        return maxProfit;
    }
}