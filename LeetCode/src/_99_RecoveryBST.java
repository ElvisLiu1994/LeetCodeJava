import java.util.LinkedList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
public class _99_RecoveryBST {
	
	public static void recoverTree(TreeNode root) {
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		
		TreeNode cur = root;
		TreeNode pre = null;
		while(cur != null || !stack.isEmpty()) {
			while(cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if(pre != null && pre.val > cur.val) {
				int tmp = pre.val;
				pre.val = cur.val;
				cur.val = tmp;
			}
			pre = cur;
			cur = cur.right;
		}
		
	}

	public static void main(String[] args) {
		
	}

}
