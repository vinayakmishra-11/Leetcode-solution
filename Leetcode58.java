class Solution {
    public int lengthOfLastWord(String s) {
        int count =0;
        boolean flag = true;
        for(int i =s.length()-1 ;i>=0;i--){
            char ch = s.charAt(i);
            if(count!=0 && flag==false && ch==' ') break;
            if(ch==' ') continue;
            count++; flag = false;
        }
        return count;
    }
}