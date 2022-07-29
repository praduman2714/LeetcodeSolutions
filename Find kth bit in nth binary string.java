class Solution {
    String st = "";
    public char findKthBit(int n, int k) {
       String str = make(n);
        return str.charAt(k-1);
    }
    
    public String make(int n){
        if(n == 1) return "0";
        if(n > 1){
           st = make(n-1) + "1"+ invert(make(n-1)); 
        }
        return st;
    }
    
    public String invert(String st){
        StringBuilder sb = new StringBuilder();
        for(char ch : st.toCharArray()){
            if(ch == '0'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        return sb.reverse().toString();
    }
}