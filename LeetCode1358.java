class Solution {
    public int numberOfSubstrings(String s) {
        int a =-1;
        int b=-1;
        int c =-1;

        int[] last = {a,b,c};
        int answer=0;

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a') a=i;
            if(ch=='b') b=i;
            if(ch=='c') c=i;

            if(a!=-1 && b!=-1 && c!=-1){
               int valid =1+ Math.min(a,Math.min(b,c));
               answer = valid +answer;
            }
        }
        return answer;
    }
}