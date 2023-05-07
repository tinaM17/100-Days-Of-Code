// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

// Example 1:

// Input: nums = [1,2,0]
// Output: 3
// Explanation: The numbers in the range [1,2] are all in the array.
// Example 2:

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.
// Example 3:

// Input: nums = [7,8,9,11,12]
// Output: 1
// Explanation: The smallest positive integer 1 is missing.

package Day27;

class Solution {
    public int firstMissingPositive(int[] nums) {
        //Step1:- Find the range of our array, if the size of the array is 7 then our range will be from 1 to 7.
        int n=nums.length;
        //take a boolean value one is false and if we found one in our array then make it true else return one because 1 is missing.
        boolean one=false;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                one=true;
            }
            //if any number is out of range then mark down it as 1.
            else if(nums[i]<1 || nums[i]>n){
                nums[i]=1;
            }
        }
        //if one false return 1.
        if(one==false) return 1;

        //Step2:- Map the elements with index
        //currently all the elements are in range
        for(int i=0;i<n;i++){
            //take the curr element as the index value and go to the index -1 position and make it negative. if it already negative then leave it as negative.
            int index=Math.abs(nums[i]);
            nums[index-1]=-Math.abs(nums[index-1]);
        }
        //Step3:- Find out the missing integer
        for(int i=0;i<n;i++){
            //traverse the array and when we get our first +ve no. in the array then return i+1; because if the i+1 value is present in our array then the current value will definitely be negative.
            if(nums[i]>0) return i+1;
        }
        //else all values are currently -ve means all are present in our array so our first missing +ve no. will be n+1;
        return n+1;
    }
}
