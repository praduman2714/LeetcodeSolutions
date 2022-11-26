class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] yes = new int[n+1];
        int[] no = new int[n+1];
        
        for(int i = n-1; i>=0; i--){
            char ch = customers.charAt(i);
            if(ch == 'Y'){
                yes[i] = yes[i+1] + 1;
            }else{
                yes[i] = yes[i+1];
            }
        }
        
        for(int i = 0; i<n; i++){
            char ch = customers.charAt(i);
            if(ch == 'N'){
                no[i+1] = no[i] + 1;
            }else{
                no[i+1] =  no[i];
            }
        }
        
        for(int i = 0; i<=n ; i++){
            yes[i]+= no[i];
        }
        int min = Integer.MAX_VALUE, minInd =-1;
        for(int i = 0; i<=n ; i++){
           // System.out.println(yes[i]);
            if(yes[i] < min){
                min = yes[i];
                minInd =i;
            }
        }
        return minInd;
    }
}