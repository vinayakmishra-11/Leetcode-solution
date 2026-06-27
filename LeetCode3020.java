class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max =1 ;
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int freq = map.get(nums[i]);
                freq++;
                map.put(nums[i],freq);
            }
            else map.put(nums[i],1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
             int len =0;
              int value = entry.getValue();
            if(key==1){
                if(map.getOrDefault(key, 0)%2!=0 && map.getOrDefault(key, 0)!=1 ){
                    len = map.get(key);
                    max=Math.max(len,max);
                    
                }
                else{
                    
                    max=Math.max(len,value-1);
                }
                continue;
            }
           
           
            while(map.getOrDefault(key, 0)>=2){
                len=len+2;
                key=key*key;
            }
            if(map.containsKey(key)){
                len=len+1;
            }
            else{
                len=len-1;
            }
            max=Math.max(len,max);
            
        }
        return max;
    }
}