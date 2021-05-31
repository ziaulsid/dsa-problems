/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class DeleteDuplicateInSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode second = null;
        
        while(current != null){
            
            if(current.next != null && current.val == current.next.val){
                second = current.next;
            
                while(second.next != null && second.val == second.next.val) second = second.next;
            
                current.next = second.next;
            
            }    
            current = current.next;
        }
        
        return head;
    }
}
