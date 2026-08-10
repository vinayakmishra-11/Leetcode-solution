class Solution {
    public static int happy(int n ){
        int sum = 0 ;
        while(n!=0){
            int x = n%10;
            x=x*x;
            sum+=x;
            n=n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        if(n==7) return true;
        if(n==1) return true;
        if(n<10) return false;
        int y = happy(n);
        return  isHappy(y);
    }
}