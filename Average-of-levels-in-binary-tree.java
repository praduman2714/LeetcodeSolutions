/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            res.add(0.00);
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            long sum = 0;
            int len = q.size();
            long c = 0;
            while(len -- > 0){
                c++;
                TreeNode node = q.poll();
                sum+= node.val;
                if(node.left!= null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            //System.out.println(sum);
            res.add((sum * 1.0)/c);
        }
        return res;
    }
}