// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

package Day19;

class Solution {
    public void moveZeroes(int[] nums) {
        //initialize an array where we have to store our temporary result
        //by default all the values of the array are 0's
        int res[] = new int[nums.length];
        // here j is the index number of the result array
        int j=0;
        //run a for loop from 0 to n-1 and search for non zero numbers
        for(int i=0;i<nums.length;i++){
            //if there exists a non zero element then put it in the res array
            if(nums[i]!=0){
                res[j++]=nums[i];
            }
        }
        //So after the loop we have just non zero elements in our new array and also maintains the order and the 0's are at the end
   
        //now copy the elements from res array to actual array
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }
    }
}