public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; ++i) {
            head.next = new ListNode(i);
            head = head.next;
        }
        System.out.println(removeNthFromEnd(cur, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode pre = head;
        int count = 0;
        while (cur != null) {
            if (count > n)
                pre = pre.next;
            cur = cur.next;
            count++;

        }

        pre.next = pre.next.next;
        return head;
    }
}
