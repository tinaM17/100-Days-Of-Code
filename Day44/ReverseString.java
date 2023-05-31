// Write a function that reverses a string. The input string is given as an array of characters s.

// You must do this by modifying the input array in-place with O(1) extra memory.

 

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
// Example 2:

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

package Day44;

class Solution {
    public void reverseString(char[] s) {
        //To solve this problem i use two pointer approach
        //i will be point to 0 and j will point the last index
        int i=0;
        int j=s.length-1;
        
        while(i<j){
            //while i less than j, swap ith character with jth one, so at the end of the loop array will reversed
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            //after swapping increase i and decrease
            i++;
            j--;
        }
    }
}
