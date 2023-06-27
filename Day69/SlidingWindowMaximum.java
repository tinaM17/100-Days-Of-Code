// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// Return the max sliding window.

// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]

package Day69;
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maximum = new int[nums.length - (k - 1)];  // Array to store the maximum values in each sliding window
        ArrayDeque<Integer> deque = new ArrayDeque<>();  // ArrayDeque to store the indices of potential maximum elements
        int i = 0;
        for (; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();  // Removing indices of smaller elements from the end of the deque
            }
            deque.addLast(i);  // Adding the current index to the end of the deque
        }
        int j = 0;
        for (; i < nums.length; i++) {
            maximum[j++] = nums[deque.peek()];  // Adding the maximum value of the previous window to the result array
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();  // Removing indices that are outside the current window from the front of the deque
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();  // Removing indices of smaller elements from the end of the deque
            }
            deque.addLast(i);  // Adding the current index to the end of the deque
        }
        maximum[j] = nums[deque.peek()];  // Adding the maximum value of the last window to the result array
        return maximum;  // Returning the array of maximum values in each sliding window
    }
}


/* Explanation and dry run example:

The function maxSlidingWindow takes an array of integers nums and an integer k as input and returns an array of maximum values in each sliding window of size k.
For example, let's assume nums = [1, 3, -1, -3, 5, 3, 6, 7] and k = 3.
In the beginning, we initialize an array maximum to store the maximum values in each window. Since k = 3, the length of the maximum array will be nums.length - (k - 1), which is 8 - (3 - 1) = 6.
We also initialize a deque (double-ended queue) named deque to store the indices of potential maximum elements within the sliding window.
We start iterating through the nums array:
First, for the initial window 1, 3, -1, we iterate from index 0 to k - 1. For each element, we check if it is greater than or equal to the element at the index stored in the deque's last position. If it is, we remove the index from the deque's last position since it is no longer a potential maximum. Then, we add the current index to the deque's last position.
During this iteration, the deque will contain the indices: deque = [1, 2], representing the indices of 3 and -1, where 3 is the maximum element in the current window.
After processing the initial window, we move to the next window 3, -1, -3. We add the maximum element of the previous window, which is 3, to the maximum array at index 0.
We then iterate through the remaining elements of nums from index k to */