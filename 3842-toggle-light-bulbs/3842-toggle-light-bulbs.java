class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {

        int[] arr = new int[101];

        for (int x : bulbs) {
            arr[x] ^= 1;
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            if (arr[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}