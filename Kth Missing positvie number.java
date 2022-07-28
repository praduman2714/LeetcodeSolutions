class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int val : arr){
            hs.add(val);
        }
        int i = 0; int j = 0;
        while(j <= k){
            if(hs.contains(i)){
                i++;
            }else{
                al.add(i);
                i++;
                j++;
            }
        }
        return al.get(al.size() -1);
    }
}