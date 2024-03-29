/**
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 *
 */

public class _109_ConvertSortedListToBST {
	
	/*
	 * 通过双指针法可以找到链表的中间节点
	 */
	public static TreeNode sortedListToBST(ListNode head) {
	    if(head == null) return null;
		
		return solve(head, null);
	}
	
	public static TreeNode solve(ListNode head, ListNode tail) {
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head == tail) return null;
	    
	    while(fast != tail && fast.next != tail) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode tmp = new TreeNode(slow.val);
	    tmp.left = solve(head,slow);
	    tmp.right = solve(slow.next,tail);
	    return tmp;
	}

	public static void main(String[] args) {

	}

}
