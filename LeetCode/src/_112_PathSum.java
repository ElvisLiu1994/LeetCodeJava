/**
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 */

public class _112_PathSum {
    
    /*
     * 使用DFS依次判断每一条路径，递归回溯
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null) return true;
        
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
