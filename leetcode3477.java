class Solution {
    public static boolean help(int i ,int fruit , int[] basket , boolean[] v){
        for(int j =0 ;j<basket.length;j++){
            if(basket[j]>=fruit &&!v[j] ){
                v[j] = true;
                return true;
            }
        }
        return false;
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] v = new boolean[fruits.length];
        int count = fruits.length;
        for(int i =0 ;i<fruits.length;i++){
            if(help(i,fruits[i],baskets,v)){
                count--;
            }
        }
        return count;
    }
}