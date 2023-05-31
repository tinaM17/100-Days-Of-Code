// Given a string S, check if it is palindrome or not.

// Example 1:

// Input: S = "abba"
// Output: 1
// Explanation: S is a palindrome
// Example 2:

// Input: S = "abc" 
// Output: 0
// Explanation: S is not a palindrome
 

// Your Task:
// You don't need to read input or print anything. Complete the function isPalindrome()which accepts string S and returns an integer value 1 or 0.

// Expected Time Complexity: O(Length of S)
// Expected Auxiliary Space: O(1)

package Day44;

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class PalindromeString {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        /**
        //Solving this problem using two pointer with the help of a char array.
        //convert the String into a char array using toCharArray() method
        char[] arr=S.toCharArray();
        
        //i will be point to 0 and j will point the last index
        int i=0,j=arr.length-1;
        while(i<=j){
            //while i less than j, check if the ith char is not equal to jth character means it is not a palindrome so return 0
            if(arr[i]!=arr[j]){
                return 0;
            }
            //if same then increase i and decrease j
            i++;
            j--;
        }
        //if it comes out of the loop means the string is palindrome so return 1
        return 1;
        **/
        
        //Without using any extra space or char Array
        
        char a,b;
        
        //i will be point to 0 and j will point the last index
        int i=0,j=S.length()-1;
        while(i<=j){
            //while i less than j, check if the ith char is not equal to jth character means it is not a palindrome so return 0
            a=S.charAt(i);
            b=S.charAt(j);
            
            if(a!=b){
                return 0;
            }
            //if same then increase i and decrease j
            i++;
            j--;
        }
        //if it comes out of the loop means the string is palindrome so return 1
        return 1;
        
        
    }
};
