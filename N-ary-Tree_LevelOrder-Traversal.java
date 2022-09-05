/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> al = new ArrayList<>();
            int len = q.size();
            while(len--  > 0){
                Node node = q.poll();
                al.add(node.val);
                for(int i = 0; i<node.children.size(); i++){
                    q.add(node.children.get(i));
                }
            }
            res.add(al);
        }
        
        return res;
    }
   
    
}