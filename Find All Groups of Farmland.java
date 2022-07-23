class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length; 
        int m = land[0].length;
        ArrayList<int[]> al = new ArrayList<>();
        //boolean[][] visited = new boolean[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j< m; j++){
                if(land[i][j] == 1){
                    //ArrayList<Integer> dumm = dfs(i, j, visited);
                    int[] arr = new int[]{i, j, 0, 0};
                    dfs(i, j, land, arr);
                    
                    al.add(arr);
                }
            }
        }
        return al.toArray(new int[al.size()][]);
       // return ans.toArray(new int[ans.size()][]);
        
    }
    
    public void dfs(int i , int j, int[][] visited, int[] arr){
       // ArrayList<Integer> al = new ArrayList<>();
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length){
            
            return ;
        }
        if(visited[i][j] == 0){
            return ;
        }
        arr[2] = Math.max(i, arr[2]);
        arr[3] = Math.max(j, arr[3]);
        visited[i][j] = 0;
         dfs(i+1, j, visited, arr);
         dfs(i-1, j, visited, arr);
         dfs(i, j-1, visited, arr);
         dfs(i, j+1, visited, arr);
        
    }
        
        
}