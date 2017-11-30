/**
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
 * @author liujing
 *
 */
public class _100_SameTree {
	
	/**
	 * 用递归的方法，两棵树相同，当且仅当，根结点的值相同，左子树相等且右子树相等
	 */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(q.val != p.val) return false;
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

	public static void main(String[] args) {
		TreeNode p = new TreeNode(new int[] {1,2,3});
		TreeNode q = new TreeNode(new int[] {1,-1,2,3});
		System.out.println(isSameTree(p,q));
	}

}
