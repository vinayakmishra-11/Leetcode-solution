//Best Solution 
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2= new int[26];

        for(int i =0; i<s.length();i++){
            freq1[s.charAt(i)-'a']++;
        }

        for(int i =0; i<s.length();i++){
            freq2[t.charAt(i)-'a']++;
        }

        for(int i =0;i<26;i++){
            if(freq1[i]!=freq2[i]) return false;
        }
        return true;
    }
}
________________________________________________________________________________________________
// Using HashMap
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            if(map1.containsKey(ch)){
                int freq = map1.get(ch);
                freq++;
                map1.put(ch,freq);
            }
            else map1.put(ch,1);
        }

         for(int i =0 ;i<s.length();i++){
            char ch = t.charAt(i);
            if(map2.containsKey(ch)){
                int freq = map2.get(ch);
                freq++;
                map2.put(ch,freq);
            }
            else map2.put(ch,1);
        }
        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            if(map1.containsKey(ch) && map2.containsKey(ch)){
                int freq = map1.get(ch);
                int freq2 = map2.get(ch);
                if(freq!=freq2) return false;
            }
            else return false;
        }

        return true;
    }
}