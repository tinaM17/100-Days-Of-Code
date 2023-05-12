// Given an array of integers nums, calculate the pivot index of this array.

// The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

// If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

// Return the leftmost pivot index. If no such index exists, return -1.

 

// Example 1:

// // Input: nums = [1,7,3,6,5,6]
// // Output: 3
// // Explanation:
// // The pivot index is 3.
// // Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
// // Right sum = nums[4] + nums[5] = 5 + 6 = 11
// // Example 2:

// // Input: nums = [1,2,3]
// // Output: -1
// // Explanation:
// // There is no index that satisfies the conditions in the problem statement.
// // Example 3:

// // Input: nums = [2,1,-1]
// // Output: 0
// // Explanation:
// // The pivot index is 0.
// // Left sum = 0 (no elements to the left of index 0)
// // Right sum = nums[1] + nums[2] = 1 + -1 = 0

package Day32;

class Solution {
    public int pivotIndex(int[] nums) {
        // Initialize 'leftsum' as 0
        int leftSum=0;
        int rightSum=0;
        // Traverse the elements and add them to store the rightSum...
        for(int i=0;i<nums.length;i++){
            rightSum+=nums[i];
        }
        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right
        for(int i=0;i<nums.length;i++){
            //check the leftSum is equal to the totalSum-currentElement-previousLeftSum then retun true
            if(leftSum==(rightSum-leftSum-nums[i])){
                return i;
            }
            //else we have to add the current num to our left sum.
            leftSum+=nums[i];
        }
        //if there is no pivot exists then return -1;
        return -1;
    }
}
