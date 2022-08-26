class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int sum1=0, sum2 = 0;
        for(int val : nums1) sum1+=val;
        for (int val : nums2) sum2 += val;
        
        if(sum1 == sum2) return 0;
        
        if(sum1 > sum2){
            return solve(nums1, nums2, sum1, sum2);
        }
        
           return solve(nums2, nums1, sum2, sum1);
        
        
    }
    
    public int solve(int[] arr, int[] arr1, int s1, int s2){
        int one = arr.length *1;
        int sec = arr1.length*6;
        if(sec < one) return -1;
        
        int i = arr.length - 1;
        int j = 0;
        int c = 0;
        while(i>= 0 || j < arr1.length){
            if(s1 <=s2) break;
            int change1= -1;
            int change2 = -1;
            
            
            if(i >=0){
                change1 = Math.abs(arr[i]-1);
            }
            if(j < arr1.length){
                change2 = Math.abs(6-arr1[j]);
            }
            
            if(change1 >= change2){
                s1 = s1-arr[i]+1;
                i--;
            }else if(change2 > change1){
                s2 = s2-arr1[j]+6;
                j++;
            }
            c++;
        }
        return c;
    }
}