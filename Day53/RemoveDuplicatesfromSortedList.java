// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]
 
package Day53;

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
    public ListNode deleteDuplicates(ListNode head) {
        //If head==null or head.next==null means there exists only one node then return head
        if(head==null || head.next==null)
           return head;

        //Else we are solving this problem using two node pointer curr and prev. prev will points the head node and curr will points the next head
        ListNode curr=head.next;
        ListNode prev=head;

       //now while curr node is exists do the loop
        while(curr!=null){
            //If the two nodes have same value then delete the current node and now the prev.next will point the curr.next node and new curr becomes curr.next node
            if(curr.val==prev.val){
                prev.next=curr.next;
                curr=curr.next;
            }
            //else both have different values so just increment the pointers to point the next nodes
            else {
                curr=curr.next;
                prev=prev.next;
            }
        }
        //After ending the loop return the head of the list
        return head;
    }
}