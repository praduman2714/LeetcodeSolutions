class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] arr = new int[256];
        int swap = 0;
        if(s1.length() != s2.length()) return false;
        for(int i =0; i<s1.length() ; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2) swap++;
            
            arr[(c1 - '0') ] ++;
            arr[(c2 - '0') ]--;
            
        }
        
        for(int val : arr){
            if(val != 0) return false;
        }
        return (swap > 2) ? false : true;
    }
}