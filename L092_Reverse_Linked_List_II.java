package LeetCode;

public class L092_Reverse_Linked_List_II {

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null || head.next == null || m == n) {
			return head;
		}

		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;

		ListNode pre = fakeHead;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
		}

		ListNode mNode = pre.next;
		for (int i = m; i < n; i++) {
			ListNode cur = mNode.next;
			mNode.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}

		return fakeHead.next;
	}

}
