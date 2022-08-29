class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val, map.getOrDefault(val, 0) + 1);
            
        }
        
        int[] nums1 = new int[arr.length];
        int i =0;
        for(int val : map.values()){
            nums1[i++] = val;
        }
        Arrays.sort(nums1);
        int[] nums= new int[nums1.length];
        for(i = 0; i<nums.length; i++){
            nums[i] = nums1[nums.length-1-i];
        }
        
        
        int[] pre = new int[arr.length];
        pre[0] = nums[0];
        for(i = 1; i<nums.length; i++){
            pre[i] = pre[i-1] + nums[i];
        }
        int k = 0;
        for(k =0;k<pre.length; k++){
            if(pre[k] >= arr.length/2){
                break;
            }
        }
        return k+1;
    }
}