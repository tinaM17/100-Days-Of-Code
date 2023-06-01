// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1

package Day45;

class Solution {
    public int firstUniqChar(String s) {
        // Stores highest index
        int ansIndex=Integer.MAX_VALUE;

        // Iterate from a to z which is 26 which makes it constant
        for(char ch='a';ch<='z';ch++){
             // indexOf will return first index of alphabet and lastIndexOf will return last index
            // if both are equal then it has occured only once.
            // through this we will get all index's which are occured once
            // but our answer is lowest index so here i used Math.min() to find the lowest index
            int index=s.indexOf(ch);

            if(index==s.lastIndexOf(ch) && index!=-1){
                ansIndex=Math.min(ansIndex,index);
            }
        }
         // If ans remain's Integer.MAX_VALUE then their is no unique character so return -1 else return ansIndex which holds our first non repeating character index
        return (ansIndex==Integer.MAX_VALUE) ? -1:ansIndex;
    }
}
