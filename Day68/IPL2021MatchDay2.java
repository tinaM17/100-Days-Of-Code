// Due to the rise of covid-19 cases in India, this year BCCI decided to organize knock-out matches in IPL rather than a league.

// Today is matchday 2 and it is between the most loved team Chennai Super Kings and the most underrated team - Punjab Kings. Stephen Fleming, the head coach of CSK, analyzing the batting stats of Punjab. He has stats of runs scored by all N players in the previous season and he wants to find the maximum score for each and every contiguous sub-list of size K to strategize for the game.

// Example 1:

// Input:
// N = 9, K = 3
// arr[] = 1 2 3 1 4 5 2 3 6
// Output: 
// 3 3 4 5 5 5 6 
// Explanation: 
// 1st contiguous subarray = {1 2 3} Max = 3
// 2nd contiguous subarray = {2 3 1} Max = 3
// 3rd contiguous subarray = {3 1 4} Max = 4
// 4th contiguous subarray = {1 4 5} Max = 5
// 5th contiguous subarray = {4 5 2} Max = 5
// 6th contiguous subarray = {5 2 3} Max = 5
// 7th contiguous subarray = {2 3 6} Max = 6
// Example 2:

// Input:
// N = 10, K = 4
// arr[] = 8 5 10 7 9 4 15 12 90 13
// Output: 
// 10 10 10 15 15 90 90
// Explanation: 
// 1st contiguous subarray = {8 5 10 7}, Max = 10
// 2nd contiguous subarray = {5 10 7 9}, Max = 10 
// 3rd contiguous subarray = {10 7 9 4}, Max = 10 
// 4th contiguous subarray = {7 9 4 15}, Max = 15
// 5th contiguous subarray = {9 4 15 12}, Max = 15 
// 6th contiguous subarray = {4 15 12 90}, Max = 90 
// 7th contiguous subarray = {15 12 90 13}, Max = 90 

// Your Task:  
// You don't need to read input or print anything. Complete the function max_of_subarrays() which takes the array, N, and K as input parameters and returns a list of integers denoting the maximum of every contiguous subarray of size K.

package Day68;

//{ Driver Code Starts
import java.util.*;

class IPL2021MatchDay2 {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();  // ArrayList to store the maximum values of subarrays

        ArrayDeque<Integer> deque = new ArrayDeque<>();  // ArrayDeque to store the indices of potential maximum elements

        int i = 0;
        for (; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();  // Removing indices of smaller elements from the end of the deque
            }
            deque.offerLast(i);  // Adding the current index to the end of the deque
        }

        for (; i < n; i++) {
            result.add(arr[deque.peek()]);  // Adding the maximum value of the previous window to the result list

            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.removeFirst();  // Removing indices that are outside the current window from the front of the deque
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();  // Removing indices of smaller elements from the end of the deque
            }
            deque.offerLast(i);  // Adding the current index to the end of the deque
        }
        
        result.add(arr[deque.peek()]);  // Adding the maximum value of the last window to the result list
        
        return result;  // Returning the list of maximum values of subarrays
    }
}
