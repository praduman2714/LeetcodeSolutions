// Tablulation
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
       // for(int[] val : dp) Arrays.fill(val, -1);
      
        dp[n][0] = dp[n][1] = 0;
        
        
        
        for(int i= n-1 ; i>=0; i-- ){
            for(int buy = 0; buy < 2; buy++){
                int profit= 0;
                if(buy == 0){
                     profit = Math.max(0+dp[i+1][0], -prices[i] + dp[i+1][1]);
                }else{
                    profit = Math.max(dp[i+1][1] , prices[i]+dp[i+1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
        
    }
    
    
}

// Memoization
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] val : dp) Arrays.fill(val, -1);
        
        return f(0, 1, prices, dp, n);
    }
    
    public int f(int ind , int buy, int[] prices, int[][] dp, int n){
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        
        int profit = 0;
        if(buy == 1){
            profit = Math.max((f(ind + 1, 0, prices, dp, n) - prices[ind]), 
                                f(ind + 1, 1, prices, dp, n));
        }else{
            profit = Math.max((f(ind + 1, 1, prices, dp, n) + prices[ind]) , 
                                f(ind + 1, 0, prices, dp, n));
        }
        
        return dp[ind][buy] = profit;
    }
}