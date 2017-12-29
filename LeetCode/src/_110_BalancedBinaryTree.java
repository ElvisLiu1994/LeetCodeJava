/**
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
 *
 */
public class _110_BalancedBinaryTree {
    /*
     * 当一棵树是平衡二叉树时，当且仅当其左右子树均是平衡二叉树，并且左右子树高度相差不超过1，运用递归的思想
     * 得出以下解，在进行递归时，对于每一个节点，都需要先递归求出其左右子树求出左右子树的高度，
     * 然后再递归求左右子树是否是平衡树，这相当是一个自顶向下的解法，复杂度为O(N^2)
     */
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true; // 递归出口
        
        int ld = depth(root.left);
        int rd = depth(root.right);
        
        return Math.abs(ld-rd) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    // 求树的高度
    public static int depth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    
    /*
     * 我们可以考虑将求深度和平衡的两个递归结合起来
     */
    public static boolean isBalanced1(TreeNode root) {
        return dfsDepth(root) != -1;
    }
    
    public static int dfsDepth(TreeNode root) {
        if(root == null) return 0;
        
        int ld = dfsDepth(root.left);
        if(ld == -1) return -1;
        int rd = dfsDepth(root.right);
        if(rd == -1) return -1;
        
        if(Math.abs(ld-rd) > 1) return -1;
        return Math.max(ld,rd)+1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
