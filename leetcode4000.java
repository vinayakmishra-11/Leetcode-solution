class Solution {
    public int largestInteger(int n, int s) {
        if(s==0) return 0;
        int largdigit =0;
        int ten =1;
        for(int i =0 ;i<n;i++){
            largdigit=(9*ten+largdigit);
            ten=ten*10;
        }
        int ans =-1 ;
        int max=0;
        for(int i = largdigit;i>=0;i--){
            int sum = 0 ;
            int num =i;
            int num2=i;
            while(num!=0){
                int y = num%10;
                sum+=y;
                if(sum>s) break;
                num=num/10;
                
            }
            if(sum==s){
                ans=Math.max(ans,num2);
            }
        }
        return ans;
        
    }
}