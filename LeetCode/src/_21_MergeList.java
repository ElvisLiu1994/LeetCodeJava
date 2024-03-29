/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * @author liujing
 *
 */

public class _21_MergeList {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode res = new ListNode(0);
		ListNode tail = res;
		while(l1 != null && l2 != null){
			ListNode temp;
			if(l1.val < l2.val){
				temp = new ListNode(l1.val);
				tail.next = temp;
				tail = tail.next;
				l1 = l1.next;
			}else{
				temp = new ListNode(l2.val);
				tail.next = temp;
				tail = tail.next;
				l2 = l2.next;
			}
			
		}
		
		while(l1 != null){
			ListNode temp = new ListNode(l1.val);
			tail.next = temp;
			tail = tail.next;
			l1 = l1.next;
		}
		
		while(l2 != null){
			ListNode temp = new ListNode(l2.val);
			tail.next = temp;
			tail = tail.next;
			l2 = l2.next;
		}
			
		return res.next;
	}
	
	//this solution is not a tail-recursive, the stack will overflow while the list is too long
	public ListNode mergeRecursively(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		if(l1.val < l2.val){
			l1.next = mergeRecursively(l1.next, l2);
			return l1;
		}else{
			l2.next = mergeRecursively(l2.next, l1);
			return l2;
		}
	}

	public static void main(String[] args) {
		_21_MergeList test = new _21_MergeList();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
//		ListNode l3 = test.mergeTwoLists(l1, l2);
		ListNode l3 = test.mergeRecursively(l1, l2);
		while(l3!=null){
			System.out.print(l3.val + " ");
			l3 = l3.next;
		}
	}

}
