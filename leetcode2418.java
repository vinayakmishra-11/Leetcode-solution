class pair{
    String name;
    int heights;
    pair(String name , int h){
        this.name=name;
        this.heights=h;
    }
}
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        ArrayList<pair> list =new ArrayList<>();

        for(int i =0;i<names.length;i++){
            list.add(new pair(names[i],heights[i]));
        }

        Collections.sort(list,(a,b)->b.heights-a.heights);

        String[] ans= new String[names.length];

        for(int i =0 ;i<names.length;i++){
            pair p = list.get(i);
            String n = p .name;
            ans[i] = n;
        }

        return ans;
    }
}