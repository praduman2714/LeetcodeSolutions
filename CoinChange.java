// Tabulation
class Solution {
    public int coinChange(int[] coins, int amount) {
       // Arrays.sort(coins);
        if(amount == 0) return 0;
       
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int [] val : dp) Arrays.fill(val, (int)(1e9));
        
        for(int i =0; i<=amount; i++){
            if(i% coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else
                dp[0][i] = (int)(1e9);
        }
        
        for(int i = 1; i<n; i++){
            for(int j = 0; j<=amount; j++){
                int not = dp[i-1][j];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= j){
                    pick = dp[i][j-coins[i]]+1;
                }
                dp[i][j] = Math.min(pick, not);
            }
        }
        return (dp[n-1][amount] == (int)(1e9) ? -1 : dp[n-1][amount]);
    }
}

// Memoization

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] val : dp) Arrays.fill(val, -2);
        int ans = f(n-1, amount, coins, dp);
        return (ans == (int) (1e9) ? -1 : ans);
    }
    
    public int f(int n , int amt, int[] arr, int[][] dp){
        if(n == 0){
            if(amt % arr[0] == 0) return amt/arr[0];
            else return (int)(1e9);
        }
        
        if(dp[n][amt] != -2) return dp[n][amt];
        
        int not = f(n-1, amt, arr, dp);
        int pick = Integer.MAX_VALUE;
        if(arr[n] <= amt){
            pick = f(n, amt-arr[n], arr, dp)+1;
        }
        return dp[n][amt] = Math.min(not, pick);
    }
}