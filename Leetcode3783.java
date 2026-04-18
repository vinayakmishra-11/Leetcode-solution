class Solution {
    public static int reverse(int n){
        int reversed = 0;

        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n = n / 10;
        }

        return reversed;
    }
    public int mirrorDistance(int n) {
        int x = reverse(n);
        return Math.abs(n-x);
    }
}