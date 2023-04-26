// Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

 

// Example 1:

// Input: num = 38
// Output: 2
// Explanation: The process is
// 38 --> 3 + 8 --> 11
// 11 --> 1 + 1 --> 2 
// Since 2 has only one digit, return it.
// Example 2:

// Input: num = 0
// Output: 0

package Day15;

class Solution {
    public int addDigits(int num) {
      //if num=0 then return 0;
      if(num==0) return 0;
      //if num less than 10 means it is a one digit number so return num
      if(num<10) return num;
      //if num is totally divisible by 9 then return 9. Ex:- 18=>1+8=9
      if(num%9==0)
         return 9;
      //else return the remainder of num module division by 9. Ex:- 38%9=2;
      return num%9;  
      
    }
}