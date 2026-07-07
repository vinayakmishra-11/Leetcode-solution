class Solution {
    public long sumAndMultiply(long n) {
        long a = n;
        long ten = 1;
        long ans =0;
        long sum=0;
        
        while(a>0){
            long mod = a%10;
            if(mod==0) {
                a=a/10;
                continue;
            }
            sum = sum+mod;
            mod = mod*ten;
            ans = ans+mod;
            ten=ten*10;
            a=a/10;
        }
     
        return ans*sum;
    }
}