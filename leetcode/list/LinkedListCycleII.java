package list;

/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Follow up:
 Can you solve it without using extra space?
 */
/*
 1. First solution, use the hashset to store the listnode
 2. The distance from head to loopstart is k.
 The length of the loop is n
 When slow get the position of loopstart, slow walked k steps, fast walked 2k steps.
 When they will meet?
 x % n == (k + 2x) % n
 so x is n - k.
 It means when they meet, the meet point is k steps away from loopstart.
 So we can just put slow at the head, then move slow and fast one step forward.
 * */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return fast;
			}
		}
		return null;
	}
}
