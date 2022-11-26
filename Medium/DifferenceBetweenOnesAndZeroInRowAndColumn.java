class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] row = new int[n][2];
        int [][] col = new int[m][2];
        
        for(int i = 0; i<n; i++){
            int cc = 0 , z =0;;
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1) cc++;
                else z++;
            }
            row[i][0] = z;
            row[i][1] = cc;
        }
        
        for(int j = 0; j<m; j++){
            int o = 0, z =0;
            for(int i = 0; i<n; i++){
                if(grid[i][j] == 1) o++;
                else z ++;
            }
            col[j][0] = z;
            col[j][1] = o;
        }
        
        int[][] res = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                res[i][j] = row[i][1] + col[j][1] - row[i][0] - col[j][0];
            }
        }
        return res;
        
    }
}