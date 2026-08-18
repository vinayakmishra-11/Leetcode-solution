class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder("");

        for(int i =0 ;i<s.length();i++){
            char ch = s.charAt(i);
            int x = (int) ch;

            if((x>=65 && x<=90) || (x>=97 && x<=122) || (x>=48 && x<=57)){
                str.append(ch);
            }
        }
        String lower = str.toString().toLowerCase();
        int i =0;
        int j=lower.length()-1;

        while(i<j){
            if(lower.charAt(i)==lower.charAt(j)){
                i++;
                j--;
            }
            else return false;

        }
        return true;

    }
}

