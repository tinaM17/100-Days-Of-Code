// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

 

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 

// Constraints:

// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

package Day63;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinStack {
    
     //Take one list to store the stack values and one priority queue to store the values in ascending order
     List<Integer> list;
     PriorityQueue<Integer> pq;
    
    //Constructor to initialize our list and priority queue
    public MinStack() {
        list=new ArrayList<>();
        pq=new PriorityQueue<>();
    }
    //in the push() method just simply add the value into the list and pq. but pq will maintain a min heap so it will the store the minimum value at the top
    public void push(int val) {
        list.add(val);
        pq.offer(val);
    }
    //in the pop() method remove the last element of the list because it is added to the first and also remove it from the priority queue
    public void pop() {
       Integer n=list.get(list.size()-1);
       list.remove(list.size()-1);
       pq.remove(n);
    }
    //in the top() method just simply return the last element in the list
    public int top() {
        return list.get(list.size() - 1);
    }
    //in the getMin() method return the top element from the queue that's the min element of the stack
    public int getMin() {
        return pq.peek();
    }
}
