class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans =0 ;
        int i =0;
       
        while(i<s.length()){
            char ch = s.charAt(i);
            if(i!=s.length()-1){
                if(ch=='C'){
                if(s.charAt(i+1)=='M' || s.charAt(i+1)=='D'){
                    ans = ans + (map.get(s.charAt(i+1))-map.get(ch));
                    i=i+2;
                }
                else {
                    ans = ans +map.get(ch);
                    i++;
                }
            }
            else if(ch=='X'){
                if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                    ans = ans + (map.get(s.charAt(i+1))-map.get(ch));
                     i=i+2;
                 }
                else {
                    ans = ans +map.get(ch);
                    i++;
                }
            }
           else  if(ch=='I'){
                if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'){
                    ans = ans + (map.get(s.charAt(i+1))-map.get(ch));
                     i=i+2;
                 }
                else {
                    ans = ans +map.get(ch);
                    i++;
                }
            }
            else{
                ans= ans+map.get(ch);
                i++;
            }
            }
            else {
                ans= ans+map.get(ch);
                i++;
            }
           
        }
        return ans;
    }
}