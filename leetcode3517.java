class Pair{
    char ch;
    int ascci;
    Pair(char ch , int ascci){
        this.ch=ch;
        this.ascci=ascci;
    }
}
class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()<=3) return s;
        int n = s.length();
        int i =0;
        int  j=0;
        if(n%2==0){
             i = n/2;
            i=i-1;
        }
        else{
            i =n/2;
        }
     
        j = s.length()-1;

        String sub1= s.substring(0,i+1);
        String sub2 = s.substring(i+1,s.length());
        ArrayList<Pair> ans1 = new ArrayList<>();
        ArrayList<Pair> ans2 = new ArrayList<>();

        for(int k =0 ;k<sub1.length();k++){
            char ch = sub1.charAt(k);
            int asci = (int)(ch);
            if(s.length()%2!=0){
                if(k==sub1.length()-1){
                     ans1.add(new Pair(ch,123));
                }
                else{
                     ans1.add(new Pair(ch,asci));
                }
            }
            else{
                ans1.add(new Pair(ch,asci));
            }
        }

        for(int k =0 ;k<sub2.length();k++){
            char ch = sub2.charAt(k);
            int asci = (int)(ch);
            ans2.add(new Pair(ch,asci));
        }

        Collections.sort(ans1,(a,b)->a.ascci-b.ascci);
        Collections.sort(ans2,(a,b)->b.ascci-a.ascci);
        StringBuilder ans3 = new StringBuilder("");
        for(int k =0 ;k<sub1.length();k++){
            ans3.append(ans1.get(k).ch);
        }
      

        for(int k=0 ;k<sub2.length();k++){
            ans3.append(ans2.get(k).ch);
        }
        return ans3.toString();


    }
}