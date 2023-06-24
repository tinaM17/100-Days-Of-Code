// Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle, and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

// Implement the MyCircularQueue class:

// MyCircularQueue(k) Initializes the object with the size of the queue to be k.
// int Front() Gets the front item from the queue. If the queue is empty, return -1.
// int Rear() Gets the last item from the queue. If the queue is empty, return -1.
// boolean enQueue(int value) Inserts an element into the circular queue. Return true if the operation is successful.
// boolean deQueue() Deletes an element from the circular queue. Return true if the operation is successful.
// boolean isEmpty() Checks whether the circular queue is empty or not.
// boolean isFull() Checks whether the circular queue is full or not.
// You must solve the problem without using the built-in queue data structure in your programming language. 

// Example 1:

// Input
// ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
// [[3], [1], [2], [3], [4], [], [], [], [4], []]
// Output
// [null, true, true, true, false, 3, true, true, true, 4]

// Explanation
// MyCircularQueue myCircularQueue = new MyCircularQueue(3);
// myCircularQueue.enQueue(1); // return True
// myCircularQueue.enQueue(2); // return True
// myCircularQueue.enQueue(3); // return True
// myCircularQueue.enQueue(4); // return False
// myCircularQueue.Rear();     // return 3
// myCircularQueue.isFull();   // return True
// myCircularQueue.deQueue();  // return True
// myCircularQueue.enQueue(4); // return True
// myCircularQueue.Rear();     // return 4

package Day65;

class MyCircularQueue {

    //Create an int array to make it as a circular queue;
    private int[] circularQueue;
    //create some variables like front,rear,size and total no. of elements
    private int front,rear,size,totalElements;

    //When an object is created with the parameter of size k, we have to initialize our array with the length of k and at the begining our front and rear will be -1 and total elements is set to 0
    public MyCircularQueue(int k) {
        circularQueue=new int[k];
        size=k;
        front=-1;
        rear=-1;
        totalElements=0;
    }
    // Inserts an element into the circular queue. Return true if the operation is successful.
    public boolean enQueue(int value) {
        //Return false if the array is full
        if(isFull())
          return false;
        //else if the array is empty means front=-1 then we have to increase our front with 0
        if(front==-1) front=0;
        //else front will point the same position but we have to increase our rear by 1. But as this is a circular queue so the last position is connected back to the first position to make a circle. So rear can come the first position again so we have increase rear by 1 then module division it by size. totalElements=totalElements+1 and return true;
        rear=(rear+1)%size;
        circularQueue[rear]=value;
        totalElements+=1;
        return true;
    }
    // Deletes an element from the circular queue. Return true if the operation is successful.
    public boolean deQueue() {
        //Return false if the array is empty
        if(isEmpty())
          return false;
        //decrease total elements
        totalElements-=1;
        //else if front==rear means in our array only one element is present so if we delete it then our array becomes empty. So we set front and rear to -1 and return true
        if(front==rear){
            front=-1;
            rear=-1;
            return true;
        }
        //Else we have to increase our front and return true;
        front=(front+1)%size;
        return true;
    }
    
    //Gets the front item from the queue.
    public int Front() {
        //If the queue is empty, return -1
        if(isEmpty())
          return -1;
        //return the elements from the array of index front
        return circularQueue[front];
    }
    
    //Gets the last item from the queue.
    public int Rear() {
        //If the queue is empty, return -1
        if(isEmpty())
          return -1;
        ////return the elements from the array of index rear
        return circularQueue[rear];
    }
    
    //Checks whether the circular queue is empty or not.
    public boolean isEmpty() {
        //if front and rear set to -1 then no elements are present in the array so return true;
        if(front==-1 && rear==-1)
          return true;
        //else false
        return false;
    }
    
    //Checks whether the circular queue is full or not
    public boolean isFull() {
        //If rear is one step behind the front pointer then it means our array is full so return true
        return (rear+1)%size==front;
        // return totalElements==size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */