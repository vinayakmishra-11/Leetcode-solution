class Solution {
    public int compress(char[] arr) {
        StringBuilder st = new StringBuilder();
        int i = 0, j = 0;

        while (j < arr.length) {
            while (j < arr.length && arr[i] == arr[j]) {
                j++;
            }
            st.append(arr[i]);
            int len = j - i;
            if (len > 1) {
                st.append(len);
            }
            i = j;
        }

        for (int k = 0; k < st.length(); k++) {
            arr[k] = st.charAt(k);
        }

        return st.length();
    }
}
