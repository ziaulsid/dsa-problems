package LinkedList;

/*
Example 1: Input: l1 = [2,4,3], l2 = [5,6,4]
                    Output: [7,0,8]
                    Explanation: 342 + 465 = 807.

        Example 2: Input: l1 = [0], l2 = [0]
                    Output: [0]

        Example 3: Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
                    Output: [8,9,9,9,0,0,0,1]*/
public class AddTowNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        ListNode firstList = l1;
        ListNode secondList = l2;

        /*Check if both the list has reached the end. If not continue*/
        while(firstList != null || secondList != null){

            /*If one of the list is null the value is set to zero*/
            int x = firstList != null ? firstList.val : 0;
            int y = secondList != null ? secondList.val : 0;
            int sum = x + y + carry;
            carry = sum /10;
            sum = sum % 10;

            curr.next = new ListNode(sum);
            curr = curr.next;
            if(firstList != null) firstList = firstList.next;
            if(secondList != null) secondList = secondList.next;
        }
        /*Check if carry is > 0. If yes that means last element was > 9 and in that case create a new Node with the value as carry. Refer example 3*/
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }
}
