class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String st : strs){
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            
            if(!map.containsKey(String.valueOf(ch))){
                List<String> al = new ArrayList<>();
                al.add(st);
                map.put(String.valueOf(ch) ,al);
            }else{
                List<String> al = map.get(String.valueOf(ch));
                al.add(st);
                map.put(String.valueOf(ch) , al);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}