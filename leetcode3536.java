class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int x = n;

        while(x!=0){
            int  y =x%10;
            list.add(y);
            x=x/10;
        }

        int product =0 ;
        Collections.reverse(list);
        int i =0 ;
        int j =list.size()-1;
        while(i<j){
            int a = list.get(j);
            int b = list.get(i);

            product=Math.max(a*b,product);

            if(a<b) j--;
            else i++;
        }
        return product;
    }
}