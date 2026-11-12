import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long currentSum = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Check if operations required to make all elements in window equal to nums[right] exceed k
            while ((long) nums[right] * (right - left + 1) - currentSum > k) {
                currentSum -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}