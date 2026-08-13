class Solution {
    public int[] findEvenNumbers(int[] arr) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i =0 ;i<arr.length;i++){
            if(hs.containsKey(arr[i])){
                int val =hs.get(arr[i]);
                val++;
                hs.put(arr[i],val);
            }
            else hs.put(arr[i],1);
        }
        for(int i=100;i<=999;i++){
            if(i%2!=0) continue;
            int x= i;
            int c = x%10; x=x/10;
            int b =x%10; x=x/10;
            int a =x;
            if(hs.containsKey(a)){
                int afre =hs.get(a);
                hs.put(a,afre-1);
                if(afre==1) hs.remove(a);
                if(hs.containsKey(b)){
                    int bfre =hs.get(b);
                    hs.put(b,bfre-1);
                    if(bfre==1) hs.remove(b);
                    if(hs.containsKey(c)){
                        ans.add(i);
                    }
                    hs.put(b,bfre);
                }
                hs.put(a,afre);
            }

        }
        int[] ans2 = new int[ans.size()];
        for(int i=0;i<ans2.length;i++){
            ans2[i]= ans.get(i);
        }
        return ans2;
    }
}