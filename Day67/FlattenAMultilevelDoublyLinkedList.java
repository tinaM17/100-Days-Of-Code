// You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

// Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

// Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

// Example 1:
// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
// Explanation: The multilevel linked list in the input is shown.
// After flattening the multilevel linked list it becomes:

// Example 2:
// Input: head = [1,2,null,3]
// Output: [1,3,2]
// Explanation: The multilevel linked list in the input is shown.
// After flattening the multilevel linked list it becomes:

// Example 3:
// Input: head = []
// Output: []
// Explanation: There could be empty list in the input.

package Day67;


// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;  // If the head is null, return null as there is no list to flatten
        }
        Node curr = head;  // Current node pointer
        Node next = null;  // Pointer to store the next node in the list
        Node child = null;  // Pointer to the child node (nested list) of the current node
        Node childTail = null;  // Pointer to the tail of the child list
        while (curr != null) {
            next = curr.next;  // Storing the next node before modifying the current node's pointers
            if (curr.child != null) {
                child = curr.child;  // Getting the child node (nested list)
                // Find the childTail (the last node of the child list)
                Node demo = child;
                while (demo.next != null) {
                    demo = demo.next;
                }
                childTail = demo;
                // Modifying the pointers to flatten the child list
                curr.next = child;  // Connecting the current node to the child node
                child.prev = curr;  // Connecting the child node to the current node
                childTail.next = next;  // Connecting the tail of the child list to the next node
                if (next != null) {
                    next.prev = childTail;  // Connecting the next node to the tail of the child list
                }
                next = child;  // Updating the next pointer to the child node
                curr.child = null;  // Removing the reference to the child node
            }
            curr = next;  // Moving to the next node in the original list
        }
        return head;  // Returning the head of the flattened list
    }
}
