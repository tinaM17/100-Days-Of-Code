// Design your implementation of the circular double-ended queue (deque).

// Implement the MyCircularDeque class:

// MyCircularDeque(int k) Initializes the deque with a maximum size of k.
// boolean insertFront() Adds an item at the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean insertLast() Adds an item at the rear of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteFront() Deletes an item from the front of Deque. Returns true if the operation is successful, or false otherwise.
// boolean deleteLast() Deletes an item from the rear of Deque. Returns true if the operation is successful, or false otherwise.
// int getFront() Returns the front item from the Deque. Returns -1 if the deque is empty.
// int getRear() Returns the last item from Deque. Returns -1 if the deque is empty.
// boolean isEmpty() Returns true if the deque is empty, or false otherwise.
// boolean isFull() Returns true if the deque is full, or false otherwise.
 

// Example 1:

// Input
// ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
// [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
// [null, true, true, true, false, 2, true, true, true, 4]

// Explanation
// MyCircularDeque myCircularDeque = new MyCircularDeque(3);
// myCircularDeque.insertLast(1);  // return True
// myCircularDeque.insertLast(2);  // return True
// myCircularDeque.insertFront(3); // return True
// myCircularDeque.insertFront(4); // return False, the queue is full.
// myCircularDeque.getRear();      // return 2
// myCircularDeque.isFull();       // return True
// myCircularDeque.deleteLast();   // return True
// myCircularDeque.insertFront(4); // return True
// myCircularDeque.getFront();     // return 4

package Day70;

class MyCircularDeque {

    int size = 0;
    int totalElements = 0;

    //Here i use Doubly linked list to make a circular deque
    class Node {
        int val;
        Node next = null;
        Node prev = null;

        Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        size = k;
        head = null;
        tail = null;
    }

    // Inserts an element at the front of the circular deque
    public boolean insertFront(int value) {
        if (totalElements == size) {
            return false;  // Cannot insert more elements, deque is full
        }
        Node newNode = new Node(value);
        totalElements++;
        if (head == null) {
            head = tail = newNode;  // First element being inserted
            return true;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return true;
    }

    // Inserts an element at the rear of the circular deque
    public boolean insertLast(int value) {
        if (totalElements == size) {
            return false;  // Cannot insert more elements, deque is full
        }
        Node newNode = new Node(value);
        totalElements++;
        if (head == null) {
            head = tail = newNode;  // First element being inserted
            return true;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return true;
    }

    // Deletes the front element of the circular deque
    public boolean deleteFront() {
        if (head == null) {
            return false;  // Cannot delete, deque is empty
        }
        totalElements--;
        if (head == tail) {
            head = tail = null;  // Last element being deleted
            return true;
        }
        head = head.next;
        head.prev = null;
        return true;
    }

    // Deletes the rear element of the circular deque
    public boolean deleteLast() {
        if (head == null) {
            return false;  // Cannot delete, deque is empty
        }
        totalElements--;
        if (head == tail) {
            head = tail = null;  // Last element being deleted
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        return true;
    }

    // Retrieves the front element of the circular deque
    public int getFront() {
        if (head == null) {
            return -1;  // Deque is empty
        }
        return head.val;
    }

    // Retrieves the rear element of the circular deque
    public int getRear() {
        if (tail == null) {
            return -1;  // Deque is empty
        }
        return tail.val;
    }

    // Checks if the circular deque is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Checks if the circular deque is full
    public boolean isFull() {
        return totalElements == size;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
