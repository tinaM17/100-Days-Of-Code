// Given an array a of integers of length n, find the nearest smaller number for every element such that the smaller element is on left side.If no small element present on the left print -1.

// Example 1:

// Input: n = 3
// a = {1, 6, 2}
// Output: -1 1 1
// Explaination: There is no number at the 
// left of 1. Smaller number than 6 and 2 is 1.
// Example 2:

// Input: n = 6
// a = {1, 5, 0, 3, 4, 5}
// Output: -1 1 -1 0 3 4
// Explaination: Upto 3 it is easy to see 
// the smaller numbers. But for 4 the smaller 
// numbers are 1, 0 and 3. But among them 3 
// is closest. Similary for 5 it is 4.
// Your Task:
// You do not need to read input or print anything. Your task is to complete the function leftSmaller() which takes n and a as input parameters and returns the list of smaller numbers.

// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(n)

package Day57;


//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class SmallestNumberOnLeft{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //Create a list to store the ans
        List<Integer> ans=new ArrayList<>();
        
        //Create a stack, by the help of this extra space we can solve our problem easily
        Stack<Integer> stack=new Stack<Integer>();
        
        //Run a for loop to iterate over the array
        for(int i=0;i<n;i++){
            //While the stack is not empty and the peek element of the stack is greater than the array element then we have to pop the element from the stack
            while(!stack.isEmpty() && stack.peek()>=a[i]){
                stack.pop();
            }
            //If the stack is empty means no smaller number is present in the left side of the array then add -1 to our list.
            if(stack.isEmpty()){
                ans.add(-1);
            }
            //Else if the stack peek element is smaller than the array element then simply add the number to the list
            else if(a[i]>stack.peek()){
                ans.add(stack.peek());
            }
            //After each operation we have to push the current element into the stack
            stack.push(a[i]);
        }
        //Finally return the list
        return ans;
    }
}