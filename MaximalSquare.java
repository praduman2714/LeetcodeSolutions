class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; i++){
            if(matrix[i][0] == '1') dp[i][0] = 1;
        }
        for(int i = 0; i<m; i++){
            if(matrix[0][i] == '1') dp[0][i] = 1;
        }
        int res = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
               if(matrix[i][j] == '1'){
                   int min = Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j], dp[i][j-1]));
                   dp[i][j] = min+1;
               } 
                
            }
            
        }
        
        for(int[] val : dp){
            for(int v : val){
                res = Math.max(res, v);
            }
        }
        
        return res*res;
    }
}