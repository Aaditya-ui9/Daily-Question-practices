import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return res;
        }

        Arrays.sort(nums);
        long targetLong = target;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            long minForI = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minForI > targetLong) {
                break;
            }

            long maxForI = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxForI < targetLong) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                long minForJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (minForJ > targetLong) {
                    break;
                }

                long maxForJ = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (maxForJ < targetLong) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == targetLong) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < targetLong) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}