// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

package Day17;
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        //sort the array first then same number will appear next to each other
        Arrays.sort(nums);
        //runs a for loop from 0 to n-2
        for(int i=0;i<nums.length-1;i++){
            //check the current number with it's next number is it same then retyrn true
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        //if all the numbers are unique into the array then return false
        return false;
    }
}
