package list_;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class ChangeList {
	public ListNode changeList(ListNode node, int dist) {
		ListNode p = node;
		ListNode q = node;
		int count = dist;
		while (count-- > 0 && q != null)
			q = q.next;
		count = dist;
		while (count-- > 0 && q != null) {
			ListNode pp = p.next;
			ListNode qq = q.next;
			p.next = q;
			if (count != 0) {
				q.next = pp;
				p = pp;
				q = qq;
			} else {
				p = qq;
				q = p;
				count = dist;
				while (count-- > 0 && q != null)
					q = q.next;
				count = dist;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(11);
		ListNode node12 = new ListNode(12);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		ChangeList c = new ChangeList();
		ListNode node = c.changeList(node1, 3);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
