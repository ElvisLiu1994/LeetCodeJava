/**
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Given 1->2->NULL and k = 3,
return 2->1->NULL.
 * @author liujing
 *
 */
public class _61_RotateList {
	/**
	 *  Let's start with an example.
	    Given [0,1,2], rotate 1 steps to the right -> [2,0,1].
		Given [0,1,2], rotate 2 steps to the right -> [1,2,0].
		Given [0,1,2], rotate 3 steps to the right -> [0,1,2].
		Given [0,1,2], rotate 4 steps to the right -> [2,0,1].
		So, no matter how big K, the number of steps is, the result is 
		always the same as rotating K % n steps to the right.
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k){
		
		if(head == null || head.next == null)
			return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy, second = dummy;
		
		int size;
		for(size = 0; second.next != null; size++)//get the total length
			second = second.next;
		
		k = k % size;

		for(int i = 0; i < size-k; i++)
			first = first.next;
		
		second.next = dummy.next;
		dummy.next = first.next;
		first.next = null;
		
		return dummy.next;
	}

	public static void main(String[] args) {
		_61_RotateList test = new _61_RotateList();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		
		ListNode res = test.rotateRight(l, 2);
		while(res != null){
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

}
