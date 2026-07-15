class Solution {
    public static int gcd(int a, int b) {
    if (b == 0)
        return a;

    return gcd(b, a % b);
}
    public int gcdOfOddEvenSums(int n) {
        int odd =0 ;
        int even=0;
        int k =1 ;
        for(int i=1; i<=n;i++){
           
           odd=odd+k;
           k=k+2; 
        }
        k=2;
        for(int i=1;i<=n;i++){
            
            even=even+k;
            k=k+2;
        }
        return gcd(even,odd);
    }
}