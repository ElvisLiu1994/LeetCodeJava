import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree [1,null,2,3], 
 * 1 
 *  \ 
 *  2 
 *  / 
 * 3 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class _94_BinaryTreeInorderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
