package b_linked_list;

public class CycleDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false; // Handle empty or single-node lists
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true; // Cycle detected
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return false; // No cycle found
	}

}
