import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 */
public class _102_BTreeLevelOrderTraversal {
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if(root == null) return res;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		
		while(root != null || !queue.isEmpty()) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
