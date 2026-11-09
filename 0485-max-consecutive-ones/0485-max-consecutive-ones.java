class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = 0;
        int currentcount = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                currentcount++;
                maxcount=Math.max(maxcount,currentcount);
            }else{
                currentcount= 0;
            }
        } return maxcount;
        
    }
}