// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class:

// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.
// Notes:

// You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

// Example 1:

// Input
// ["MyQueue", "push", "push", "peek", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 1, 1, false]

// Explanation
// MyQueue myQueue = new MyQueue();
// myQueue.push(1); // queue is: [1]
// myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
// myQueue.peek(); // return 1
// myQueue.pop(); // return 1, queue is [2]
// myQueue.empty(); // return false

package Day64;
import java.util.*;

class MyQueue {

    private Stack<Integer> stack;  // Stack to store the elements of the queue.
    private Stack<Integer> temp;   // Temporary stack used for reorganizing elements.
    public MyQueue() {
        stack = new Stack<>();  // Initializing the main stack
        temp = new Stack<>();   // Initializing the temporary stack
    }
    
    public void push(int x) {
        stack.push(x);  // Adding an element to the end of the queue (top of the stack)
    }
    
    public int pop() {
        while (stack.size() != 1) {
            temp.push(stack.pop());  // Moving all elements except the last one to the temporary stack
        }
        int data = stack.pop();  // Removing and returning the last element (front of the queue)
        while (!temp.isEmpty()) {
            stack.push(temp.pop());  // Restoring the elements from the temporary stack to the main stack
        }
        return data;  // Returning the removed element
    }
    
    public int peek() {
        while (stack.size() != 1) {
            temp.push(stack.pop());  // Moving all elements except the last one to the temporary stack
        }
        int data = stack.peek();  // Retrieving the last element (front of the queue) without removing it
        while (!temp.isEmpty()) {
            stack.push(temp.pop());  // Restoring the elements from the temporary stack to the main stack
        }
        return data;  // Returning the retrieved element
    }
    
    public boolean empty() {
        return stack.isEmpty();  // Checking if the queue is empty by checking if the main stack is empty
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
