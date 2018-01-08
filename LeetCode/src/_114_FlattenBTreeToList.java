/**
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 *
 */
public class _114_FlattenBTreeToList {
    /*
     * 使用递归的方法，将左右子树都flatten，然后将左子树拼接到右子树上
     * 
     * 该方法的缺点是每次要遍历到左子树的最右节点，然后进行插入。
     */
    public static void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        
        flatten(root.left);
        flatten(root.right);
        
        // 将左子树插入到右子树
        TreeNode tmp = root.left;
        if(tmp != null) {
            while(tmp.right != null) tmp = tmp.right;
        
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    

    private TreeNode prev = null;
    /*
     * 针对上述方法的改进，利用prev指针来保存前一个flatten过的节点
     * 这里先将右子树进行flatten，prev记录下了flatten后的当前右子树节点
     * 这样对左子树进行flatten可以直接将prev拼接到左子树的右底节点上
     * 然后左子树flatten完，prev会保存左子树节点，然后被插入到root的右子树
     */
    public void flatten1(TreeNode root) {
        if(root == null) return;
        
        flatten1(root.right);
        flatten1(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new int[] {1,2,3,-1,-1,4,-1,-1,5,-1,6});
        flatten(root);
    }

}
