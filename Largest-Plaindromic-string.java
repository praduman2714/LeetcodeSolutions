class Solution {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for(char ch : num.toCharArray()){
            count[ch-'0']++;
        }
        //for(int val : arr) System.out.print(val+ "  ");
        //System.out.println();
        int single = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--)
        {
            if(sb.length()==0 && i==0)
                continue;
            
            while(count[i] > 1)
            {
                sb.append((char)(i+48));
                count[i] -=2;
            }
            if(count[i] == 1 && single == -1)
                single = i;
        }
        
        if(sb.length() == 0 && single == -1)
            return "0";
        
        int i = sb.length()-1;
        if(single != -1) sb.append((char) (single+48));
        for(; i>=0; i--){
            sb.append(sb.charAt(i));
        }
        return sb.toString();
    }
}