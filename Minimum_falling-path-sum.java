class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        for(int [] val : dp) Arrays.fill(val, -1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            min = Math.min(min, f(n-1, i, matrix, dp));
        }
        return min;
    }
    
    public int f(int i, int j, int[][] matrix, int[][] dp){
        if(j < 0 || j >= matrix[0].length) return (int)(1e9);
        if(i == 0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];
        
        int up = matrix[i][j] + f(i-1, j, matrix, dp);
        int left = matrix[i][j] + f(i-1, j-1, matrix, dp);
        int right = matrix[i][j] + f(i-1, j+1, matrix, dp);
        return dp[i][j] = Math.min(up, Math.min(left, right));
    }
}

// Tabulation

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        //for(int val[] : dp) Arrays.fill(val, Integer.MAX_VALUE);
        for(int i =0;i<m; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i<n; i++){
            for(int j = 0; j<m ; j++){
                int down = (i>0)? matrix[i][j] + dp[i-1][j] : Integer.MAX_VALUE;
                int left = (j>0) ? matrix[i][j] + dp[i-1][j-1]: Integer.MAX_VALUE;
                int right =(j+1 < matrix[0].length)? matrix[i][j] + dp[i-1][j+1]: Integer.MAX_VALUE;
                dp[i][j] = Math.min(down, Math.min(left, right));
            }
        }
        
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
    
   
}