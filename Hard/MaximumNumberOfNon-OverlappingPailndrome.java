class Solution {
    public int maxPalindromes(String s, int k) {
        int c = 0;
       
        for(int i = 0; i<s.length() ; i++){
            //StringBuilder sb = new StringBuilder();
            String st= "";
            for(int j = i; j<s.length(); j++){
                //sb.append(s.charAt(j));
                st+=s.charAt(j);
                if(st.length() > k+1) break;
                if(st.length() >= k && isPalindrome(st)) {
                    //System.out.println(st);
                    c++;
                    i= j;
                    break;
                }
            }
        }
        
        return c;
    }
    
    public boolean isPalindrome(String st){
        int i = 0, j= st.length() - 1;
        while(i <= j){
            if(st.charAt(i)  != st.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}