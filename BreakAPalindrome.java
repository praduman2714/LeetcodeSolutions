class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        int n = palindrome.length() ;
        boolean flag = false;
        StringBuilder sb = new StringBuilder(palindrome);
        //String st = "";
        for(int i = 0;i< n/2 ; i++){
            char ch = palindrome.charAt(i);
            if(ch != 'a'){
                sb.setCharAt(i, 'a');
                flag = true;
                break;
            }
        }
        if(flag == false){
            sb.setCharAt(n-1, 'b');
        }
        return sb.toString();
    }
}