class Solution {
    public int maxVowels(String s, int k) {
     Set<Character> set = new HashSet<>();

       set.add('a');
       set.add('e');
       set.add('i');
       set.add('o');
       set.add('u');
       int len =0;

       for(int i =0;i<k;i++){
        char ch = s.charAt(i);
        if(set.contains(ch)) len++;
       }
       int max = len;

       for(int i =k;i<s.length();i++){
        char prev = s.charAt(i-k);
        char next = s.charAt(i);

        if(set.contains(prev)) len--;
        if(set.contains(next)) len++;
        max=Math.max(len,max);
       }

       return max;
    }
}