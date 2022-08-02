class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return false;
        Boolean[] visited = new Boolean[s.length()];
        return wb(s, wordDict, visited, 0);
    }
    
    public boolean wb(String s, List<String> wd, Boolean[] visited, int st){
        if(st >= s.length()) return true;
        if(visited[st] != null) return visited[st];
        
        visited[st] = false;
        
        for(int i = st+1; i<=s.length()&& !visited[st] ; i++){
            String sub = s.substring(st, i);
            if(wd.contains(sub)){
                visited[st] = wb(s, wd, visited, i);
            }
        }
        return visited[st];
    }
}