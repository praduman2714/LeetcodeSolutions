class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int val : nums){
            if(val % 2 == 0)
                map.put(val, map.getOrDefault(val, 0)+ 1);
        }
        int maxFreq = 0;
        int max = -1;
        for(int val : map.keySet()){
            if(map.get(val) > maxFreq){
                maxFreq = map.get(val);
                max = val; 
            }
        }
        return max;
    }
}