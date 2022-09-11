class Solution {
    public int partitionString(String s) {
        int i=0, j= 0;
        int c = 1;
        HashSet<Character> hs = new HashSet<>();
        while(j < s.length()){
            
            if(!hs.contains(s.charAt(j))){
                System.out.println(s.charAt(j));
                hs.add(s.charAt(j));
            }else{
                c++;
                hs = new HashSet<>();
                System.out.println(s.charAt(j) + " " + " else ");
                hs.add(s.charAt(j));
            }
            j++;
        }
        return c;
    }
}