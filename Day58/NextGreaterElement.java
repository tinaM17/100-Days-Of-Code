// Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.

// Example 1:

// Input: 
// N = 4, arr[] = [1 3 2 4]
// Output:
// 3 4 4 -1
// Explanation:
// In the array, the next larger element 
// to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
// since it doesn't exist, it is -1.
// Example 2:

// Input: 
// N = 5, arr[] [6 8 0 1 3]
// Output:
// 8 -1 1 3 -1
// Explanation:
// In the array, the next larger element to 
// 6 is 8, for 8 there is no larger elements 
// hence it is -1, for 0 it is 1 , for 1 it 
// is 3 and then for 3 there is no larger 
// element on right and hence -1.
// Your Task:
// This is a function problem. You only need to complete the function nextLargerElement() that takes list of integers arr[ ] and N as input parameters and returns list of integers of length N denoting the next greater elements for all the corresponding elements in the input array.

// Expected Time Complexity : O(N)
// Expected Auxiliary Space : O(N)

package Day58;


import java.util.*;
import java.io.*;

class NextGreaterElement {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        //Create a array of type long to store the ans
        long[] result=new long[n];
        //Create a stack, by the help of this extra space we can solve our problem easily
        Stack<Long> stack=new Stack<>();
        
        //Run a for loop to iterate over the array from the last element/right most element
        for(int i=n-1;i>=0;i--){
             //While the stack is not empty and the peek element of the stack is smaller than the array element then we have to pop the element from the stack
            while(!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            //If the stack is empty means no greater number is present in the right side of the array then add -1 to our current index of the result array.
            if(stack.isEmpty()){
                result[i]=-1;
            }
            //Else if the stack peek element is greater than the array element then simply add the number to our current index of the result array.
            else if(stack.peek()>arr[i]) {
                result[i]=stack.peek();
                
            }
            //After each operation we have to push the current element into the stack    
            stack.push(arr[i]);
        }
         //Finally return the array
        return result;
    } 
}
