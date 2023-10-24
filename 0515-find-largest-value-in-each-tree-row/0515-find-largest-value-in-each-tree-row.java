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
    public List<Integer> largestValues(TreeNode root) {
     List<Integer> result = new ArrayList<>();
     dfs(root,0,result);
     return result; 
    }
    private void dfs(TreeNode node,int level,List<Integer> result){
      if(node==null){
          return;
      }  
      if(level==result.size()){
             result.add(node.val);
            } else {
        result.set(level, Math.max(result.get(level), node.val));
    }
    dfs(node.left, level + 1, result);
    dfs(node.right, level + 1, result);

      
    }
}