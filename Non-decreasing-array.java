class Solution {
    public boolean checkPossibility(int[] arr) {
        int count = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i-1] > arr[i]){
                if(count == 1) return false;
                count++;
                if(i < 2 || arr[i-2] <= arr[i]){
                    arr[i-1] = arr[i];
                }else{
                    arr[i] =arr[i-1];
                }
            }
        }
        return true;
    }
}


// Method-2

class Solution {
    public boolean checkPossibility(int[] nums) {
        int pos = -1;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                if(pos != -1){
                    return false;
                }
                pos = i;
            }
        }
        
        return pos == -1 || pos == 0 || pos == nums.length - 2 || nums[pos-1] <= nums[pos+1] ||
            nums[pos]<= nums[pos+2];
    }
}