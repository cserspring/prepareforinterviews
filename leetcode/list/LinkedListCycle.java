package list;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (p != null && q != null) {
			p = p.next;
			q = q.next;
			if (q != null)
				q = q.next;
			if (p == q)
				return true;
		}
		return false;
	}

	public boolean hasCycleII(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
