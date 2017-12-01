import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 *
 */
public class _101_SymmetricTree {
	
	/*
	 *  根据定义可得，它的中序遍历结果也为对称的，可以通过中序遍历结果判断。
	 *  
	 *  提交之后通过了的测试为191/193，出问题的树结构为：
	 *          1
	 *         / \
	 *        2   3
	 *       /   /
	 *      3   2
	 * 它的中序遍历结果为32123,也是对称的，但整棵树不是对称的
	 */
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
        	while(cur != null) {
        		stack.push(cur);
        		cur = cur.left;
        	}
        	cur = stack.pop();
        	res.add(cur.val);
        	cur = cur.right;
        }
        
        for(int i = 0; i < res.size()>>1; i++) {
        	if(res.get(i) != res.get(res.size() - i - 1))
        		return false;
        }
        return true;
        
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(new int[] {3241242});
		System.out.println(isSymmetric(root));
	}

}
