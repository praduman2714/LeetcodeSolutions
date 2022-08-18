// Memoization
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for(int[] val : dp) Arrays.fill(val, -1);
        return f(n-1, m-1, s, t, dp);
        
    }
    
    public int f(int i, int j, String s, String t, int[][] dp){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int match = 0, not = 0;
        if(s.charAt(i) == t.charAt(j)){
            match = f(i-1, j-1,s, t, dp) + f(i-1, j, s, t, dp);
        }else{
            not = f(i-1, j, s, t, dp);
        }
        return dp[i][j] = match + not;
    }
}

// Tabulation

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int j = 0; j<=m; j++){
            dp[0][j] = 0;
        }
        
        for(int i = 0; i<=n ;i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i<=n; i++){
            for(int j = 1;j<=m; j++){
                int match = 0;
                int not =0;
                if(s.charAt(i-1) == t.charAt(j-1)){
                    match= dp[i-1][j-1] + dp[i-1][j];
                }else{
                    not = dp[i-1][j];
                }
                dp[i][j] = match+not;
            }
        }
        return dp[n][m];
    }
}