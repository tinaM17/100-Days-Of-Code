// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

 

// Example 1:

// Input: nums = [2,2,1]
// Output: 1
// Example 2:

// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:

// Input: nums = [1]
// Output: 1

package Day11;

class Solution {
    public int singleNumber(int[] nums) {
        //initialize our ans var to 0
        int ans=0;
        //runs a for loop from 0 to n-1
        for(int i=0;i<nums.length;i++){
            //we know if we xor two same numbers then it returns 0 and if we xor a number with 0 then it returns the non zero number.
            //example, 2^2=0, 0^3=3
            // nums= [2,2,1]
            // 2^2=0 and 0^1=1; so our result will be the single number
            ans=ans^nums[i];
        }

        return ans;
    }
}