class Solution {
    public static  int StringToNumber(String str){
        int num =0 ;
        for(int i =0 ;i<str.length();i++){
            int digit = str.charAt(i)-'0';
            num=(num*10+digit);
        }
        return num;
    }
    public List<Integer> sequentialDigits(int low, int high) {
        int lowDigi =0;
        int highDigi=0;
        int l=low;
        int h=high;

        while(l!=0){
            l=l/10;
            lowDigi++;
        }

        while(h!=0){
            h=h/10;
            highDigi++;
        }
        StringBuilder str = new StringBuilder("123456789");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = lowDigi ;i<=highDigi;i++){
            for(int j =0 ; j+i<=str.length();j++){
                String sub = str.substring(j,j+i);
                int x = StringToNumber(sub);
                if(x>= low && x<=high) list.add(x);
            }
        }
        return list;
    }
}