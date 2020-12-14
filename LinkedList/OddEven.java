package LinkedList;
/*Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4].*/

/*
Intuition: Divide the list into two halves i.e odd and even list and then merge it at the end.

Create 4 pointers head and tail for both the odd and even list. Start with 3rd node i.e 1 -> 3 -> 5 && 2 -> 4 -> 6
*/
class OddEven {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddHead = head;
        ListNode oddTail = head;
        
        ListNode evenHead = head.next;
        ListNode evenTail = head.next;
        
        ListNode temp = evenHead.next;
        
        while(temp != null){
            oddTail.next = temp;
            oddTail = temp;
            
			//Special Case: When the next node is null that means we have reached the end of the list. And even tail is still pointing to the last node so to avoid cycles explicitly mark the next of eventTail as null. 
            if(null == temp.next) {
                evenTail.next = null;
                break;
            }   
            else temp = temp.next;
            evenTail.next = temp;
            evenTail = temp;
            
            temp = temp.next;
        }
        
        oddTail.next = evenHead;
        return head;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
