import java.util.*;
class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character,Integer> target_map = new HashMap<>();
        int[] ans = new int[target.length()];
        for(int i =0 ;i<target.length();i++){
            char ch = target.charAt(i);
            if(target_map.containsKey(ch)){
                int freq = target_map.get(ch);
                freq++;
                target_map.put(ch,freq);
            }
            else target_map.put(ch,1);
        }
        HashMap<Character,Integer> s_map = new HashMap<>();
        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            if(s_map.containsKey(ch)){
                int freq = s_map.get(ch);
                freq++;
                s_map.put(ch,freq);
            }
            else s_map.put(ch,1);
        }

        for(int i =0 ;i<target.length();i++){
            char ch =target.charAt(i);
            if(s_map.containsKey(ch)){
                ans[i] = s_map.get(ch)/target_map.get(ch);
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<ans.length;i++){
            min=Math.min(ans[i],min);
        }
        return min;
    }
}