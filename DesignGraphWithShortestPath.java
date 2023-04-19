class Graph {
    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    int n;
    
    public Graph(int n, int[][] edges) {
        this.n = n;
        
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] arr : edges){
            int from = arr[0];
            int to  = arr[1];
            int dis = arr[2];
            
            adj.get(from).add(new int[]{to, dis});
        }
    }
    
    public void addEdge(int[] arr) {
        int from = arr[0];
        int to  = arr[1];
        int dis = arr[2];
            
        adj.get(from).add(new int[]{to, dis});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[1] - j[1]);
        boolean vis[] = new boolean[n];
        
        pq.add(new int[]{node1 , 0});
        
        //vis[node1] = true;
        
        while(!pq.isEmpty()){
            int[] front = pq.poll();
            int edge = front[0];
            int dis = front[1];
           
            if(vis[edge]){
                continue;
            }
            
            vis[edge] = true;
            
            if(edge == node2) return dis;
            
            
            
            
            for(int[] val : adj.get(edge)){
                if(vis[val[0]] == false){
                    pq.add(new int[]{val[0], dis+val[1]});
                    //vis[val[0]] = true;
                }
                
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */