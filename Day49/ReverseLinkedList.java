// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Example 1:

// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:

// Input: head = [1,2]
// Output: [2,1]
// Example 3:

// Input: head = []
// Output: []

package Day49;
import java.util.*;

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
    public ListNode reverseList(ListNode head) {

        //if the linked list has no element or just one element then return the head pointer
        if(head==null || head.next==null)
           return head;
        
        //else create a prev pointer to point initially null and a current pointer to point the head
        ListNode prev = null;  
        ListNode current = head;
    
        //while current!=null means while the end of the list iterate the loop
        while(current != null) { 
            //initialize a next pointer to point the current's next node
            ListNode next = current.next; 
            //now point the current.next value to the previous one to make reverse link btw them
            current.next = prev;
            //now move the prev pointer to one
            prev = current;
            //and move the current pointer to one
            current = next;
        }
        //finally return the prev pointer which will our head pointer for the reversed list
       return prev; 


    }
}
