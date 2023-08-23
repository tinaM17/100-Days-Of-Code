// Given a 2D matrix M of dimensions RxC. Find the maximum sum submatrix in it.

// Example 1:

// Input:
// R=4
// C=5
// M=[[1,2,-1,-4,-20],
// [-8,-3,4,2,1],
// [3,8,10,1,3],
// [-4,-1,1,7,-6]]
// Output:
// 29
// Explanation:
// The matrix is as follows and the
// blue rectangle denotes the maximum sum
// rectangle.
// Thumbnail
// Example 2:

// Input:
// R=2
// C=2
// M=[[-1,-2],[-3,-4]]
// Output:
// -1
// Explanation:
// Taking only the first cell is the 
// optimal choice.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function maximumSumRectangle() which takes the number R, C, and the 2D matrix M as input parameters and returns the maximum sum submatrix.


// Expected Time Complexity:O(R*R*C)
// Expected Auxillary Space:O(R*C)

package Day98;

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
       int sumArray[] = new int[R]; // Array to store the sum of elements in each row
       int maxSum = Integer.MIN_VALUE; // Initialize the maximum sum with a very small value
       
       for(int cStart = 0; cStart < C; cStart++) {
           Arrays.fill(sumArray, 0); // Reset the sum array for each column start
           for(int cEnd = cStart; cEnd < C; cEnd++) {
               // Calculate the cumulative sum for each row within the specified column range
               for(int i = 0; i < R; i++) {
                   sumArray[i] = sumArray[i] + M[i][cEnd];
               }
               // Compute the maximum sum of subarray using Kadane's algorithm
               int currSum = kadanes(sumArray);
               // Update the maximum sum if the current subarray sum is greater
               maxSum = Math.max(maxSum, currSum);
           }
       }
       return maxSum; // Return the maximum sum of subarray in the entire matrix
    }
    
    // Function to find the maximum sum of subarray using Kadane's algorithm
    int kadanes(int[] sumArray) {
        int size = sumArray.length;
        int max = Integer.MIN_VALUE; // Initialize the maximum sum with a very small value
        int currMax = 0;
        
        for(int i = 0; i < size; i++) {
            currMax = currMax + sumArray[i]; // Add the current element to the running sum
            if(currMax > max) {
                max = currMax; // Update the maximum sum if the running sum is greater
            }
            if(currMax < 0) {
                currMax = 0; // Reset the running sum if it becomes negative
            }
        }
        return max; // Return the maximum sum of subarray
    }
};

