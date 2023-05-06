// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

// If target is not found in the array, return [-1, -1].

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]

package day26;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        //declaring our result array where we store our index values
        int[] result=new int[2];
        //call our two functions which return our first and last occurrence index and store it on our result array and return the array
        result[0]=firstOccur(nums,target);
        result[1]=lastOccur(nums,target);

        return result;
    }
//function for finding the first occurrence of our target element
    public int firstOccur(int[] nums,int target){
        //initialize our two pointer low and high
        int low=0,high=nums.length-1;
        //initialize our ans variable to -1 because if target is not present then return -1;
        int ans=-1;
        while(low<=high){
            //first find the mid of the array and if the target=nums[mid] then store the mid into our ans variable and check it's left side for finding it's first position so our new high become mid-1;
             int mid=(low+high)/2;
             if(nums[mid]==target){
                 ans=mid;
                 high=mid-1;
             }
             //else if target less than mid then check it's left side for finding it's first position so our new high become mid-1;
             else if(target<nums[mid]){
                 high=mid-1;
             }
             //else our target present on right side so our low become mid+1;
             else 
                low=mid+1;
        }
        // return the first position
        return ans;
    }
//function for finding the last occurrence of our target element
     public int lastOccur(int[] nums,int target){
         //initialize our two pointer low and high
        int low=0,high=nums.length-1;
        //initialize our ans variable to -1 because if target is not present then return -1;
        int ans=-1;

        while(low<=high){
            //first find the mid of the array and if the target=nums[mid] then store the mid into our ans variable and check it's right side for finding it's last position so our new low become mid+1;
             int mid=(low+high)/2;
             if(nums[mid]==target){
                 ans=mid;
                 low=mid+1;
             }
             //else if target less than mid then check it's left side for finding it's last position so our new high become mid-1;
             else if(target<nums[mid]){
                 high=mid-1;
             }
             //else our target present on right side so our low become mid+1;
             else 
                low=mid+1;
        }
        // return the last position
        return ans;
    }
}
