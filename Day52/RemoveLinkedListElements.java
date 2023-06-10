// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

// Example 1:


// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
// Example 2:

// Input: head = [], val = 1
// Output: []
// Example 3:

// Input: head = [7,7,7,7], val = 7
// Output: []

package Day52;

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
    public ListNode removeElements(ListNode head, int val) {
        //If head is null then return null
        if(head==null)
        {
            return null;
        }
        //else create a dummy node to track our new head. So dummy.next=head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        //create a curr node to point the dummy node as starting
        ListNode curr=dummy;
        //So while there exists a node we are traversing the loop
        while(curr.next!=null){
            //if our curr.next node has a similar value then we have to remove it, so break the link btw them and curr.next will point to the next node so middle node get deleted
            if(curr.next.val==val){
                curr.next=curr.next.next;
            }
            //else does not contain similar value so simply move our curr pointer to the next node
            else {
                curr=curr.next;
            }
        }
        //finally return the dummy.next node which is our new head
         return dummy.next;
    }
}
