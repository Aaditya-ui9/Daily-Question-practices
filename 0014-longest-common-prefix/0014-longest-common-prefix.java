class Solution {
    public String longestCommonPrefix(String[] strs) {

        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;

            while (j < ans.length() &&
                   j < strs[i].length() &&
                   ans.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            ans = ans.substring(0, j);

            if (ans.isEmpty()) {
                return "";
            }
        }

        return ans;
    }
}