// A peak element is an element that is strictly greater than its neighbors.

// Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// You must write an algorithm that runs in O(log n) time.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Example 2:

// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.


package day26;

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0; // single element
        
        int n = nums.length;
        
		// check if 0th/n-1th index is greater than it's next/previous value then it's our peak element so return it's index
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
		
		//else our peak lies btw our 1 to n-2th index so, search in the remaining array
        int start = 1;
        int end = n-2;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;   //if mid is greater than it's neighbour elements then it is our peak element so return mid;
            else if(nums[mid] < nums[mid-1]) end = mid - 1;
            //else if mid less than it's left side value then so search on the left side now our end become mid-1;
            else if(nums[mid] < nums[mid+1]) start = mid + 1;
            //else if mid less than it's right value then search on the right side now our start become mid+1;
        }
        return -1; // if no peak found return -1
    }
}
