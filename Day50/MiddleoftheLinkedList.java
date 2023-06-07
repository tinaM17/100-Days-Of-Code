// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

// Example 1:

// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// Example 2:


// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

package Day50;

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
    public ListNode middleNode(ListNode head) {
        //We first initialized the slow pointer and the fast pointer to point to the head of the linked list.
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            //For each iteration, the slow pointer moves one node and the fast pointer moves 2 nodes
            fast=fast.next.next;
            slow=slow.next;
        }
        //At the end of loop the fast pointer reaches the end of the list, the slow pointer will be pointing to the middle node
        return slow;
    }
}
