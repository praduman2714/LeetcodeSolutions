class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] val : dp){
            for(int[] v : val){
                Arrays.fill(v, -1);
            }
        }
        
       return  f(0, 1, k, prices, dp, n);
    }
    
    public int f(int ind, int buy, int cap, int[] arr, int[][][] dp, int n){
        if(ind == n || cap == 0) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[ind] + f(ind+1, 0, cap, arr, dp, n) ,
                             f(ind+1, 1, cap, arr, dp, n));
        }else{
            profit = Math.max(arr[ind] + f(ind+1,1,cap-1,arr,dp,n),
                              0 + f(ind+1, 0, cap,arr,dp,n));
        }
        return dp[ind][buy][cap]  = profit;
    }
}