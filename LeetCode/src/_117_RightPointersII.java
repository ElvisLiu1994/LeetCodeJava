import java.util.LinkedList;

/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 *
 */
public class _117_RightPointersII {
    
    /*
     * 队列的方法依旧很方便解决
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

}
