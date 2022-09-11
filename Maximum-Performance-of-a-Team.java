class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int engg[][] = new int[n][2];
        for(int i = 0 ;i<n; i++){
            engg[i][0] = efficiency[i];
            engg[i][1] = speed[i];
        }
       
        Arrays.sort(engg, (a, b) -> b[0]-a[0]);
        
        /** for(int[] val : engg){
            System.out.println(val[0] +" " +  val[1]);
        } **/
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0 , ans = 0;
        for(int i =0; i<n; i++){
            if(pq.size() >= k){
                sum-=pq.poll();
            }
            pq.add(engg[i][1]);
            sum+=engg[i][1];
            ans = Math.max(ans, sum*engg[i][0]);
        }
        return (int) (ans % 1000000007);
    }
}