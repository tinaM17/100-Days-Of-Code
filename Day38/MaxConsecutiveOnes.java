// Given a binary array nums, return the maximum number of consecutive 1's in the array.

// Example 1:

// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
// Example 2:

// Input: nums = [1,0,1,1,0,1]
// Output: 2

package Day38;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //initialize our two variable to store the number of ones and max consecutive ones
        int ones=0;
        int consecutiveOnes=0;

        //run a for loop from 0 to n-1
        for(int i=0;i<nums.length;i++){
            //if we found a 0 then assign 0 to our ones variable 
            if(nums[i]==0){
                ones=0;
            }
            //if we found a 1 then add one to our ones and update consecutiveOnes to the max value btw them.
            else {
                ones++;
                consecutiveOnes=Math.max(ones,consecutiveOnes);
            }
        }
        //return the max consecutiveOnes
        return consecutiveOnes;
    }
}
