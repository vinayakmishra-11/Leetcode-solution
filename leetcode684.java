class Solution {
    public static int find(int a,int[] parent){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a],parent);
    }
    public static void union(int a ,int b ,int[] ans,int[] size , int[] parent){
        int la = find(a,parent);
        int lb = find(b,parent);

        if(la==lb){
            ans[0]=a;
            ans[1]=b;
        }
        if(size[la]>size[lb]){
            parent[lb] = la;
            size[la] = size[lb]+size[la];
        }
        else{
              parent[la] = lb;
            size[lb] = size[la]+size[lb];
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] size = new int[edges.length+1];

        for(int i=0;i<=edges.length;i++){
            parent[i]=i;
            size[i] =1 ;

        }
        int[] ans = new int[2];
        for(int i =0 ;i<edges.length;i++){
            union(edges[i][0],edges[i][1],ans,size,parent);
        }
        return ans ;
    }
}