class Solution {
    public static int product(int n ){
        int sum =1;
        while(n!=0){
            int y = n%10;
            sum*=y;
            n=n/10;
        }
        return sum;
    }
    public static int sum(int n ){
        int sum =0;
        while(n!=0){
            int y = n%10;
            sum+=y;
            n=n/10;
        }
        return sum;
    }
    public boolean checkDivisibility(int n) {
        int sum = sum(n);
        int pro = product(n);
        int add = sum+pro;
        if(n%add==0) return true;
        return false;
    }
}

