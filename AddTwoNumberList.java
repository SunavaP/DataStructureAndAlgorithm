public class AddTwoNumberList {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode rtrn = head;
        int rem = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1==null?0:l1.val;
            int val2 = l2==null?0:l2.val;
            int sum = rem + val1 + val2;
            rem = sum / 10;
            head.next = new ListNode(sum % 10);
            head = head.next;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        if(rem > 0)
            head.next = new ListNode(rem);
        return rtrn.next;
    }
}
