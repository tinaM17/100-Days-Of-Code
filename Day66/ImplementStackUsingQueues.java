// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:

// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.
// Notes:

// You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
// Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

// Example 1:

// Input
// ["MyStack", "push", "push", "top", "pop", "empty"]
// [[], [1], [2], [], [], []]
// Output
// [null, null, null, 2, 2, false]

// Explanation
// MyStack myStack = new MyStack();
// myStack.push(1);
// myStack.push(2);
// myStack.top(); // return 2
// myStack.pop(); // return 2
// myStack.empty(); // return False

package Day66;
import java.util.*;

class MyStack {
    // Queue to store the elements of the stack
    private Queue<Integer> queue;  
    // Temporary queue used for reorganizing elements
    private Queue<Integer> temp;   
    

    public MyStack() {
        // Initializing the main queue
        queue = new ArrayDeque<>();  
        // Initializing the temporary queue
        temp = new ArrayDeque<>();  
    }
    
    public void push(int x) {
        //Moving all elements from the main queue to the temporary queue
        while (!queue.isEmpty()) {
            temp.offer(queue.poll());  
        }
         // Adding the new element to the front of the main queue
        queue.offer(x); 
        while (!temp.isEmpty()) {
            // Restoring the elements from the temporary queue to the main queue
            queue.offer(temp.poll());  
        }
    }
    
    public int pop() {
        // If the stack is empty, return -1 as there is no element to remove
        if (empty()) {
            return -1;  
        }
        // Removing and returning the top element from the stack (front of the queue)
        return queue.poll();  
    }
    
    public int top() {
        // If the stack is empty, return -1 as there is no element at the top
        if (empty()) {
            return -1;  
        }
        // Returning the top element from the stack (front of the queue) without removing it
        return queue.peek();  
    }
    
    public boolean empty() {
        // Checking if the stack is empty by checking if the queue is empty
        return queue.isEmpty();  
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
