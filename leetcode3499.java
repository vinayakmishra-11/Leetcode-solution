class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) != s.charAt(j)) {
                int len = j - i;
                if (s.charAt(i) == '0')
                    list.add(len);
                i = j;
            }
        }
        int numberofone = 0;
        for (int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            if (ch == '1')
                numberofone++;
        }
        int len = s.length() - i;
        if (s.charAt(i) == '0')
            list.add(len);
        // int len = s.length() - i;

        // if (s.charAt(i) == '0')
        //     list.add(len);
        // else
        //     list.add(len);
        int ans = 0;
        for (int k = 1; k < list.size(); k++) {
            ans = Math.max(ans, list.get(k) + list.get(k - 1));
        }

        ans += numberofone;

        return ans;
    }
}