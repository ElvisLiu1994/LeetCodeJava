/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 */

class ListNode{
	int val;
	ListNode next;
	
	ListNode(int x){
		this.val = x;
	}
}

public class _19_RemoveFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null || n <= 0)
			return head;
		
		ListNode prior = head;
		int i;
		for(i = 0; i < n && prior != null; i++){
			prior = prior.next;
		}
		if(prior == null && i == n){ // remove head
			head = head.next;
			return head;
		}
		
		ListNode cur = head;
		while(prior.next != null){
			prior = prior.next;
			cur = cur.next;
		}
		cur.next = cur.next.next;
		
		return head;
	}
	

	public static void main(String[] args) {
		_19_RemoveFromEnd test = new _19_RemoveFromEnd();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = test.removeNthFromEnd(head, 2);
		while(head != null){
			System.out.print(head.val+" ");
			head = head.next;
		}
	}

}


