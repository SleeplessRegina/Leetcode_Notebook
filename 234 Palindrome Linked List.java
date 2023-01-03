// Given the head of a singly linked list, return true if it is a 
// palindrome
//  or false otherwise.

//  1 -> 2 -> 2 -> 1 true
//  1 -> 2 false

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

//use the thought of two pointers to find middle point
//also the thoughts of reverse a linkedList
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        if(head == null){
            return false;
        }
        //find middle point of linkedList
        while(fast != null && fast.next != null){
            prev = prev.next;//prev node of middle point
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // break from the middle point
        ListNode newNode = reverse(slow);
        //compare reversed right part with left part of linkedList
        while(head != null){
            if(head.val != newNode.val){
                return false;
            }
            head = head.next;
            newNode = newNode.next;
        }
        return true;
    }

    //reverse second part in place
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

//Time complexity: o(n);
//space complexity: o(1);