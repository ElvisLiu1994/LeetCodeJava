/**
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 */
public class _111_MinimunDepthOfTree {
    
    /*
     * 这种做法有个问题就是，对于某个子树为null的情况，将会返回0，然后整个树的minDepth为1比如：
     * 1
     *  \
     *   2
     * 它的minDepth应该为2，但是实际返回的是1，还需要保证不考虑为null的子树
     */
    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
    
    public static int minDepth1(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
