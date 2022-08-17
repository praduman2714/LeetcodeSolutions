class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String s2 = sb.reverse().toString();
        int[][] dp = new int[n][n];
        
        for(int[] val: dp) Arrays.fill(val, -1);
        return f(n-1, n-1, s, s2, dp);
    }
    
    public int f(int i, int j, String s, String t, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int match = 0;
        int not = 0;
        if(s.charAt(i) == t.charAt(j)){
            match = 1+f(i-1, j-1, s, t, dp);
        }else{
            not = Math.max(f(i-1, j, s, t ,dp), f(i, j-1, s, t, dp));
        }
        return dp[i][j] = Math.max(not, match);
    }
}