package LinkedList;

public class DeleteNNodesFromList {

    public ListNode deleteNodes(ListNode head, int m, int n) {

        ListNode current = head;
        ListNode mNode = null;
        int currentSize = 1;
        while(current != null){
            int mCount = m;
            int nCount = n;

            while(current != null && mCount != 0){
                mNode = current;
                current = current.next;
                mCount--;
            }

            while(current != null && nCount != 0){
                current = current.next;
                nCount--;
            }
            mNode.next = current;
        }
        return head;
    }
}
