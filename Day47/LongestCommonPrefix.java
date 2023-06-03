// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

package Day47;
import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Sort the elements of an array of strings in lexicographic (alphabetical) order using the Arrays.sort(strs) method
        Arrays.sort(strs);
        //Assign the first element & last element of the sorted array (the lexicographically smallest string) to a string variable s1 & s2.
        String s1=strs[0];
        String s2=strs[strs.length-1];
        //Initialize an integer variable index to 0.
        int index=0;
        //Start a while loop that continues while index is less than the length of s1 and s2
        while(index<s1.length() && index<s2.length()){
            //Within the while loop, check if the character at the current index in s1 is equal to the character at the same index in s2. If the characters are equal, increment the value of index by 1
            if(s1.charAt(index)==s2.charAt(index))
               index++;
            //else exit from the loop
            else
               break;
        }
        //Return the substring of s1 that starts from the first character and ends at the index th character (exclusive)
        return s1.substring(0,index);
    }
}