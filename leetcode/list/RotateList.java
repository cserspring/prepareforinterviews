package list;

/*
 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 * */
public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (n < 0 || head == null)
			return head;

		int len = 0;
		ListNode p = head;
		ListNode q = head;
		while (p != null) {
			p = p.next;
			++len;
		}
		n = n % len;
		if (n == 0)
			return head;
		p = head;
		while (q != null && n-- > 0) {
			q = q.next;
		}
		while (q.next != null) {
			p = p.next;
			q = q.next;
		}
		ListNode newHead = p.next;
		q.next = head;
		p.next = null;
		return newHead;
	}
}
