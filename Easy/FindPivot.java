class Solution {
    public int pivotInteger(int n) {
        int tSum = (n*(n+1)) / 2;
        //System.out.println(tSum);
        int pivot = -1;
        int sum = 0;
        for(int i = 1; i<=n; i++){
            if(sum == tSum - sum -i){
                return i;
            }
            sum+=i;
           // System.out.println(sum + " " + (tSum-sum - i));
        }
        return pivot;
    }
}