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
    int[] arr = new int[10];
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root);
        return ans;
    }
    
    public void helper(TreeNode root){
        if(root == null) return ;
        arr[root.val]++;
        if(root.left == null && root.right == null){
            int count = 0;
            for(int val : arr){
                count+= val%2;
            }
            if(count == 1 || count == 0) ans++;
        }
        
        helper(root.left);
        helper(root.right);
        arr[root.val]--;
    }
}