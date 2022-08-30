class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int i = 0; int j = 0;
        int sum = 0;
        while(j < nums.length){
            sum+=nums[j];
             max = Math.max(max, sum);
            if(sum <= 0){
                sum = 0;
                i = j;
            }
           // max = Math.max(max, sum);
            j++;
        }
        return max;
    }
}