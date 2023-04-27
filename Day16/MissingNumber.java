// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Example 1:

// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
// Example 2:

// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
// Example 3:

// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

package Day16;

public class MissingNumber {
    class Solution {
    public int missingNumber(int[] nums) {
        //size of the array
        int n=nums.length;
        //we know the formula of the sum of n natural numbers= n*(n+1)/2
        int sum=(n*(n+1))/2;
        //initialize another variable to store our array element sum
        int arrSum=0;
        //runs a for loop to sum of the array
        for(int i=0;i<n;i++){
             arrSum+=nums[i];
        }
        //now subtract the n sum to the array sum and we get our missing number
        //example:- nums=[0,1,4,3], n=4
        // nSum= 4*(4+1)/2=10
        //arrSum=0+1+4+3= 8
        //ans= 10-8=2
        //So,missing number is 2.
        return sum-arrSum;
    }
}
}
