// Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

// A good subarray is a subarray where:

// its length is at least two, and
// the sum of the elements of the subarray is a multiple of k.
// Note that:

// A subarray is a contiguous part of the array.
// An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

// Example 1:

// Input: nums = [23,2,4,6,7], k = 6
// Output: true
// Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
// Example 2:

// Input: nums = [23,2,6,4,7], k = 6
// Output: true
// Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
// 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
// Example 3:

// Input: nums = [23,2,6,4,7], k = 13
// Output: false

package Day34;
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //if the size of the array is less than true means there does not exists a good subarray so return false
        if(nums.length<2)
           return false;
        
        //else here we use a hashmap to store our remainder and index number
        Map<Integer,Integer> map=new HashMap<>();

        map.put(0,-1);
        int currSum=0;
        //runs a for loop from 0 to n to find our prefix sum and the remainder
        for(int i=0;i<nums.length;i++){
            //currSum is the previous sum+our current index element
            currSum+=nums[i];
            //now check the remainder of the current sum
            int rem=currSum%k;
            //check if the remainder is already present as a key in the hashmap
            if(map.containsKey(rem)){
                //if present then check the difference btw their index numbers, if the difference greater than one means the size of the subarray at least two return true
                int size= i - map.get(rem);
                if(size>1)
                {
                    return true;
                }
            }
            //if not then put the remeinder and index value to our hashmap
            else 
               map.put(rem,i);
        }
        //else we don't find any good subarray so return false;
        return false;
    }
}