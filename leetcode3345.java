class Solution {
    public static int product(int n){
        int p =1;
        while(n!=0){
            int y = n%10;
            p=p*y;
            n=n/10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) { 
      // while(product(n)%t!=0)n++;
      for(int i =n;i<=100;i++){
        if(product(i)%t==0) return i;
      }
       return 1;
    }
}