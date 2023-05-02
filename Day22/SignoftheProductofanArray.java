// There is a function signFunc(x) that returns:

// 1 if x is positive.
// -1 if x is negative.
// 0 if x is equal to 0.
// You are given an integer array nums. Let product be the product of all values in the array nums.

// Return signFunc(product).

// Example 1:

// Input: nums = [-1,-2,-3,-4,3,2,1]
// Output: 1
// Explanation: The product of all values in the array is 144, and signFunc(144) = 1
// Example 2:

// Input: nums = [1,5,0,2,-3]
// Output: 0
// Explanation: The product of all values in the array is 0, and signFunc(0) = 0
// Example 3:

// Input: nums = [-1,1,-1,1,-1]
// Output: -1
// Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

package Day22;

 
class Solution {
    public int arraySign(int[] nums) {
        //initialize our product variable to 1
        int product=1;
        //runs a for loop from 0 to n-1 to check all the values of the array
        for(int i=0;i<nums.length;i++){
            //if array contains a zero then return 0 from here because any number multiply with zero result will be zero.
            if(nums[i]==0){
                return 0;
            }
            //if the current number is +ve then multiply with 1
            else if(nums[i]>0)
            {
                product *=1;
            }
            //else if our current number is less than 0 means -ve then multiply our product with -1
            else 
                product *=-1;
        }
        //now check if our product less than zero then return -1 else return 1
        if(product<0) return -1;

        return 1;
    }
}
