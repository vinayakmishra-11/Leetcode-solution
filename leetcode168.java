class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder ans = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--; // Convert to 0-based

            int rem = columnNumber % 26;

            char ch = (char) ('A' + rem);

            ans.append(ch);

            columnNumber = columnNumber / 26;
        }

        return ans.reverse().toString();
    }
}