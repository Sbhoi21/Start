package test_copilot;

import java.util.LinkedList;
import java.util.List;

public class DetectCycleInLinkedList {

	public static void main(String[] args) {
	
		ListNode head = new DetectCycleInLinkedList().new ListNode(3);
		ListNode second = new DetectCycleInLinkedList().new ListNode(2);
		ListNode third = new DetectCycleInLinkedList().new ListNode(0);
		ListNode fourth = new DetectCycleInLinkedList().new ListNode(-4);
		
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = second;
		
		System.out.println(hasCycle(head));
	}
	
	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}
	
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
