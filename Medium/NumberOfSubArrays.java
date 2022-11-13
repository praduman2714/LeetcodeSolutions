class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int c = 0;
        for(int i = 0; i<nums.length; i++){
            List<Integer> al = new ArrayList<>();
            //al.add(nums[i]);
            for(int j = i ; j<nums.length ; j++){
                int vv = (al.isEmpty()) ? 1 : al.get(al.size() - 1);
                al.add(lcm(vv, nums[j]));
            }
            for(int val : al){
                //System.out.print(val + " ");
                if(val == k) c++;
            }
            //System.out.println();
        }
        return c;
    }
    
        private  int gcd(int a, int b) {
            return (b == 0 ? a : gcd(b, a % b));
        }
    
        private  int lcm(int a, int b) {
            return ((a * b) / gcd(a, b));
        }
}
