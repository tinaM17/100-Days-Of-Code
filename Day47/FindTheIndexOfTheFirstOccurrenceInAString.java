// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.

package Day47;

class Solution {
    public int strStr(String haystack, String needle) {
  //The contains() method checks whether a string contains a sequence of characters. Returns true if the characters exist and false if not.
        if(haystack.contains(needle)){
            //The indexOf() method returns the position of the first occurrence of specified character(s) in a string.
            return haystack.indexOf(needle);
        }
        //Else return -1;
        return -1;
    }
}
