// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// Example 2:
// Input: head = [1,2], pos = 0
// Output: tail connects to node index 0
// Explanation: There is a cycle in the linked list, where tail connects to the first node.
// Example 3:


// Input: head = [1], pos = -1
// Output: no cycle
// Explanation: There is no cycle in the linked list.


package Day55;


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
    public ListNode detectCycle(ListNode head) {
        //Call the method isCyclePresent(head) if it returns null then simply return null because there is no cycle exists else store the node in a meet pointer
        ListNode meet=isCyclePresent(head);
        if(meet==null){
            return null;
        }
        ////Initialize start pointer, to the head of the linked list.
        ListNode start=head;

        //While the start pointer is not equal to the meet pointer, do this
        while(start!=meet){
            //Move the two pointers one step ahead.
            start=start.next;
            meet=meet.next;
        }
        //They will meet a point where the cycle begins so return the meet or start pointer
        return start;
    }

//Method to find a cycle is present or not and return the node.
    public ListNode isCyclePresent(ListNode head){
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
            if(fast==slow)
               return slow;
        }
        //If the fast pointer reaches the end of the linked list (i.e., becomes null), return false to indicate no cycle in the list.
        return null;
    }
}
