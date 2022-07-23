class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int [] suff = new int[nums.length];
        pre[0] = nums[0];
        for(int i = 1 ; i<nums.length ; i++){
            pre[i]=pre[i-1]+nums[i];
        }
        suff[nums.length-1] = nums[nums.length - 1];
        for(int i = nums.length-2; i>=0; i--){
            suff[i] = suff[i+1]+nums[i];
        }
        
        for(int i =0; i<nums.length ; i++){
            if(pre[i] == suff[i]) return i;
            else if(pre[i] == 0 && i == nums.length -2) return nums.length - 1;
            else if(suff[i] == 0 && i == 1) return 0;
        }
        return -1;
    }
}