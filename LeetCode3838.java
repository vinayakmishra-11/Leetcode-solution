class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Integer,Character> map = new HashMap<>();
        String ansString="";
        int k =0;
        int ans =0;
        for(int i =122;i>=97;i--){
            char ch = (char) i;
            map.put(k,ch);
            k++;
        }

        for(int i =0 ;i<words.length;i++){
            String str =words[i];
            ans =0;
            for(int j =0; j<str.length();j++){
                char ch = str.charAt(j);
                int place =( (int) ch) %97;
                ans =ans + weights[place];
            }
            ans =ans%26;
            ansString = ansString+ map.get(ans);
            
        }
        return ansString;
    }
}