public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        if(head == null) return null;

        ListNode first = head;
        ListNode second = head;

        ListNode result = new ListNode(-1);
        ListNode dummy = result;

        while(first != null){
            if(first.val < x) {
                dummy.next = new ListNode(first.val);
                dummy = dummy.next;
            }
            first = first.next;
        }

        while(second != null){
            if(second.val >= x) {
                dummy.next = new ListNode(second.val);
                dummy = dummy.next;
            }
            second = second.next;
        }

        return result.next;
    }
}
