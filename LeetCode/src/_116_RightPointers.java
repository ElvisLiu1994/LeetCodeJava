import java.util.LinkedList;

/**
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 *
 */
public class _116_RightPointers {
    
    /*
     * 利用队列进行BFS，但是空间复杂度是O(n)
     */
    public static void connect(TreeLinkNode root) {
        if(root == null) return;
        
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++) {
                TreeLinkNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
                //对前levelNum个把next指针的指向队列首个节点即可
                if(i != levelNum-1) {
                    top.next = queue.peek();
                }
            }
        }
        return;
    }
    /*
     * 下面这个算法没有使用队列，空间复杂度为O(1)，dummy当作每一层的虚拟头节点使用，dummy.next记录每一层的开始
     * curChild主要用来在每一层进行连接
     * 
     */
    public static void connect1(TreeLinkNode root) {
        
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode curChild = dummy;
        while(root != null){
            if(root.left!=null) { curChild.next = root.left; curChild = curChild.next;}
            if(root.right != null) { curChild.next = root.right; curChild = curChild.next;}
            root = root.next;
            if(root == null) {
                curChild = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
