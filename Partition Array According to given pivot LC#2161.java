Naive Solution
***************
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        for(int val : nums){
            if(val < pivot){
                small.add(val);
            }else if(val > pivot){
                greater.add(val);
            }else{
                equal.add(val);
            }
        }
        int k = 0;
        for(int val : small){
            arr[k++] = val;
        }
        for(int val : equal){
            arr[k++] = val;
        }
        for(int val : greater){
            arr[k++] = val;
        }
        return arr;
    }
}

Time Optimize solutions
***********************
Two Pointer Approach

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] arr = new int[nums.length];
        int left = 0; int right = nums.length - 1;
        for(int i = 0; i<nums.length ; i++){
            if(nums[i] < pivot) arr[left++] = nums[i];
            if(nums[nums.length - 1-i] > pivot) arr[right--] = nums[nums.length - 1- i];
        }
        while(left <= right){
            arr[left++] = pivot;
        }
        return arr;
    }
}
