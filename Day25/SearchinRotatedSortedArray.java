// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.


// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1

package Day25;

class Solution {
    public int search(int[] nums, int target) {
        //initialize our two pointer low and high
        int low=0, high=nums.length-1;
        while(low<=high){
            //first find the mid of the array and if the target=nums[mid] then return mid
            int mid=(low+high)/2;
            if(nums[mid]==target) return mid;
            // else we have to check which part is sorted left or right
            //So, if our low value less than equal to mid value then our left part is sorted so we discard the right part
            if(nums[low]<=nums[mid]){
                //now check if the target actually lies on the left side or not.So, if target greater than or equals to low and less than equals to mid then search on the left side so our new high=mid-1
                 if(target>=nums[low] && target<=nums[mid]){
                     high=mid-1;
                 }
                 //else our target lies on the right side so search on the right side so our new low=mid+1
                 else 
                    low=mid+1;
            }
            //So, our left part is not sorted disard the left part
            else {
                //now check if the target actually lies on the right side or not.So, if target greater than or equals to mid and less than equals to high then search on the right side so our new low=mid+1
                if(target>=nums[mid] && target<=nums[high]){
                     low=mid+1;
                 }
                 //else our target lies on the left side so search on the left side so our new high=mid-1
                 else 
                    high=mid-1;
            }
        }
        //else target not present in the array so return -1;
        return -1;
    }
}
