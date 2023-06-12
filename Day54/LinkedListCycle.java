// Given head, the head of a linked list, determine if the linked list has a cycle in it.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.

package Day54;

//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

class Solution {
    public boolean hasCycle(ListNode head) {
        //if the head is null or just only one node is present which next is null then return false because there is no cycle
        if(head==null || head.next==null){
            return false;
        }
        //Initialize two pointers, slow and fast, to the head of the linked list.
        ListNode fast=head;
        ListNode slow=head;
        
        //While the fast pointer is not null and the fast.next pointer is not null, do this
        while(fast!=null && fast.next!=null){
            //Move the fast pointer two steps ahead.
            fast=fast.next.next;
            //Move the slow pointer one step ahead.
            slow=slow.next;
            //If the slow pointer becomes equal to the fast pointer, return true to indicate the presence of a cycle.
            if(fast==slow){
                return true;
            }
        }
        //If the fast pointer reaches the end of the linked list (i.e., becomes null), return false to indicate no cycle in the list.
        return false;
    }
}