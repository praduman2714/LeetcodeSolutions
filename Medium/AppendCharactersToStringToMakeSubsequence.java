class Solution {
    public int appendCharacters(String s, String t) {
        int ind = 0;
        for(int i = 0; i<t.length() ; i++){
            char ch = t.charAt(i);
            boolean flag = false;
            for(int j = ind; j<s.length(); j++){
                char ch1 = s.charAt(j);
                if(ch == ch1){
                    ind = j+1;
                     flag = true;
                    break;
                }
            }
            if(flag == false){
                return t.length() - i;
            }
        }
        return 0;
    }
}