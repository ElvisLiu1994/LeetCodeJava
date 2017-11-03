import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example: Given binary tree [1,null,2,3], 
 *  1 
 *   \ 
 *    2 
 *   / 
 *  3 
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 */
public class _94_BinaryTreeInorderTraversal {

	// 递归方法
	public static List<Integer> inorderTraversal(TreeNode root) {
		
		if(root == null) return new ArrayList<Integer>();
		
		List<Integer> res = new ArrayList<Integer>();
		
		res.addAll(inorderTraversal(root.left));
		res.add(root.val);
		res.addAll(inorderTraversal(root.right));
		
		return res;
		
	}
	
	// 
	public static List<Integer> inorderTraversal1(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		
		if(root == null) return res;
		
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			TreeNode top = stack.peek();
			while(top.left != null) {
				stack.push(top.left);
				top = top.left;
			}
			
			top = stack.pop();
			res.add(top.val);
			
			if(top.right != null){
				stack.push(top.right);
			}
			
		}
		
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		System.out.println(inorderTraversal1(root));
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	TreeNode(int[] nums) {
		
		for(int x : nums) {
			
		}
	}
}
