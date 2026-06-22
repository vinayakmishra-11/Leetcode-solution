class Solution {
    public int maxNumberOfBalloons(String text) {
        String str = "balloon";
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0 ;i<text.length();i++){
            char ch = text.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                freq++;
                map.put(ch,freq);
            }
            else map.put(ch,1);
        }
        
        for(int i =0 ; i <str.length();i++){
            char ch = str.charAt(i);
            if(!map.containsKey(ch)) return 0;
        }
       int  b= map.get('b');
       int a = map.get('a');
       int l= map.get('l');
       int o = map.get('o');
       int n = map.get('n');
         
        return Math.min(b,Math.min(a,Math.min(l/2,Math.min(o/2,n)))) ;
    }
}