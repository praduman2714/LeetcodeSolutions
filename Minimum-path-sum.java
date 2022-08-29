class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        
        for(int[] val : dp) Arrays.fill(val, -1);
        
        return f(n-1, m-1, grid, dp);
    }
    
    public int f(int i, int j, int[][] grid, int[][] dp){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0 ) return (int)(1e9);
        //if(j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int right = (int)(1e9), left = (int)(1e9);
        
            right = grid[i][j] + f(i, j-1, grid, dp);
        
       
             left = grid[i][j] + f(i-1, j, grid, dp);
        return dp[i][j] = Math.min(left, right);
    }
}