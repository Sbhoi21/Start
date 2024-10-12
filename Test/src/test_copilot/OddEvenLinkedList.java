package test_copilot;

import d_linked_list.ListNode;

public class OddEvenLinkedList {

	
	// LC. 328 Odd Even Linked List
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

}
