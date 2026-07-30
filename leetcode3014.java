class Solution {
    public int minimumPushes(String word) {
        if(word.length()<=8) return word.length();
        int ans =0 ;
        int count=0;
        int push =1;
        for(int i =0 ;i<word.length();i++){
            if(count!=0){
                if(count%8==0){
                push++;
            }
            }
            ans+=push;
            count++;
        }
        return ans ;

    

    }
}