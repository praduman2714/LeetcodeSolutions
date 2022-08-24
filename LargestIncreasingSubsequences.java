class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> al = new ArrayList<>();
        for(int i =0; i<n; i++){
            if(al.size() == 0 || al.get(al.size() - 1) < nums[i])
                al.add(nums[i]);
            int ind = bs(al, nums[i]);
            al.set(ind, nums[i]);
        }
        return al.size();
    }
    
    public int bs(List<Integer> list , int x){
        int l = 0, r = list.size() - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (list.get(mid) >= x)
                r = mid;
            else
                l = mid;
        }
        if (list.get(l) >= x) return l;
        return r;
    }
}