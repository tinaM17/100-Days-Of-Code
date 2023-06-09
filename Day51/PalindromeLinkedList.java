// Given the head of a singly linked list, return true if it is a 
// palindromeor false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

package Day51;

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
class Solution {
    public boolean isPalindrome(ListNode head) {
        //If the list is empty or only one node is there then return true
        if(head==null || head.next==null){
            return true;
        }
        //else find the mid node of the list
        ListNode mid=middle(head);
        //Then from the mid node reverse the list to check the first half data with the last half data
        ListNode last=reverse(mid);
        //Initialize curr pointer to head
        ListNode curr=head;
        //While loop for checking if the first node holds the same value with the last node or not and so on
        while(last!=null){
            //if the values are not equal then it's not a palindrome return false directly
            if(last.val!=curr.val){
                return false;
            }
            //else increase our pointer for further iterations
            else {
                last=last.next;
                curr=curr.next;
            }
        }
        //after the loop return true because the list contains palindrome
        return true;
    }
   
   //Method to find the mid node of a linked list
    public ListNode middle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //Method to reverse a linked list
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null)
           return head;
        
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}
