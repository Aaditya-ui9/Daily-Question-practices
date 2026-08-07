import java.util.*;

class Solution {

    private static final List<Integer> palindromes = new ArrayList<>();

    static {
        int LIMIT = 1 << 14;

        for (int i = 1; i < LIMIT; i++) {
            if (isBinaryPalindrome(i)) {
                palindromes.add(i);
            }
        }
    }

    public int[] minOperations(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];

            int idx = Collections.binarySearch(palindromes, x);

            if (idx >= 0) {
                ans[i] = 0;
            } else {
                idx = -idx - 1;

                int best = Integer.MAX_VALUE;

                if (idx < palindromes.size()) {
                    best = Math.min(best, palindromes.get(idx) - x);
                }

                if (idx > 0) {
                    best = Math.min(best, x - palindromes.get(idx - 1));
                }

                ans[i] = best;
            }
        }

        return ans;
    }

    private static boolean isBinaryPalindrome(int x) {
        int original = x;
        int reversed = 0;

        while (x > 0) {
            reversed <<= 1;
            reversed |= (x & 1);
            x >>= 1;
        }

        return reversed == original;
    }
}