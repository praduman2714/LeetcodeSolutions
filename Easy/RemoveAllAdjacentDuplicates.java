class Solution {
    public String removeDuplicates(String s) {
       Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(st.isEmpty() == false && ch == st.peek()){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        String res = "";
        while(!st.isEmpty()){
            res = st.pop() + res;
        }
        return res;
    }
}

