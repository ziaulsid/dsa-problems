package LinkedList;

import java.util.Stack;
/*PROBLEM DESCRIPTION:
        Given a singly linked list, determine if it is a palindrome.

        Example 1:
        Input: 1->2
        Output: false

        Example 2:
        Input: 1->2->2->1
        Output: true*/
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null){
            stack.add(temp.val);
            temp = temp.next;
        }

        while (head != null){

            if (head.val != stack.pop()) return false;
            else head = head.next;
        }
        return true;
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
