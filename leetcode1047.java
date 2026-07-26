class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        int i =0 ;
        while(i<s.length()){
            if(stack.isEmpty()) stack.push(s.charAt(i));
          else  if(stack.peek()==s.charAt(i)) stack.pop();
          else stack.push(s.charAt(i));
            i++;
        }
        StringBuilder ans = new StringBuilder("");

        while(!stack.isEmpty()){
             char ch = stack.pop();
            ans.append(ch);
        }
        return ans.reverse().toString();
    }
}