import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals 
the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 *
 */
public class _113_PathSumII {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        solve(root, sum, cur, res);
        return res;
    }
    
    public void solve(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        
        if(root == null) return;
        
        cur.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<Integer>(cur));
            cur.remove(cur.size()-1); //由于在本次递归中使用了add，再添加到res中的，所以返回时，需要将cur中的remove掉
            return;
        }
        if(root.left != null) {
            solve(root.left, sum-root.val, cur, res);
        }
        if(root.right != null) {
            solve(root.right, sum-root.val, cur, res);
        }
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
