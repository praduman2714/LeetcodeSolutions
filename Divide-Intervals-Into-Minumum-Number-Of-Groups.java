class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] - b[0]);
        int c = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 1, n = intervals.length;
        
        for(int i = 0; i<n; i++){
            int st = intervals[i][0];
            int end = intervals[i][1];
            
            if(!pq.isEmpty() && pq.peek() > st){
                ans++;
            }else if(!pq.isEmpty()) pq.poll();
            pq.offer(end+1);
        }
        return ans;
    }
}