class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch , int freq){
            this.ch=ch;
            this.freq=freq;
        }
    }
    public int minimumPushes(String word) {
        if(word.length()<=8) return word.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0 ;i<word.length();i++){
            char ch = word.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                freq++;
                map.put(ch,freq);
            }
            else map.put(ch,1);
        }

        ArrayList<Pair> list = new ArrayList<>();

        for(HashMap.Entry<Character,Integer> entry :map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            list.add(new Pair(ch,freq));
        }

        Collections.sort(list,(a,b)->b.freq-a.freq);
        int count =0;
        int push =1 ;
        int ans=0;
        for(int i =0 ;i<list.size();i++){
            if(count!=0){
                if(count%8==0){
                    push++;
                }
            }
            Pair p = list.get(i);
            int freq = p.freq;
            ans+=(freq*push);
            count++;

        }

        return ans;
       
    }
}

------------------------------------------------
// BETTER CODE THAN ABOVE 
class Solution {
    public int minimumPushes(String word) {
        if(word.length()<=8) return word.length();
        int[] freq = new int[26];
        int k =0 ;
        while(k<word.length()){
            char ch = word.charAt(k);
            int x = (int)(ch-'a');
            int y = freq[x];
            y++;
            freq[x]=y;
            k++;
        }
        Arrays.sort(freq);
        int ans =0;
        int count =0;
        int push =1 ;
        for(int i = freq.length-1;i>=0;i--){
            if(count!=0){
                if(count%8==0){
                    push++;
                }
            }
            ans+=(push*freq[i]);
            count++;
        }
        return ans;
    }
}