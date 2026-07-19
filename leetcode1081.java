// class Solution {
//     public String (String s) {
        
//     }
// }

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];

        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            int x = ch - 'a';
            freq[x]++;
        }

        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            int x = ch-'a';
            freq[x]--;
            if (inStack[ch - 'a']) {
                   continue;
              }
            while(!stack.isEmpty() && stack.peek() > ch && freq[stack.peek()-'a']>0){
                char chh = stack.pop();
                inStack[chh-'a'] = false;
            }

            stack.push(ch);
            inStack[ch-'a'] = true;
        }
        StringBuilder ans = new StringBuilder("");

        while(!stack.isEmpty()){
            char ch = stack.pop();
            ans.append(ch);
        }

        return ans.reverse().toString();
    }
}