// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.

 

// Example 1:

// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: nums = [3,1,3,4,2]
// Output: 3

package Day9;
import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) {
        // int n=nums.length-1;
        // int sum=n*(n+1)/2;
        // int arrSum=0;
        // for(int i=0;i<nums.length;i++){
        //     arrSum+=nums[i];
        // }
        // return arrSum-sum;
        //this approach is not works when the array is like=[2,2] so i have another approach

        //step1:-create a hashmap to store the number and it's occurrence
        HashMap<Integer,Integer>map=new LinkedHashMap<>();

        for(int i=0;i<nums.length;i++){
            //if the map contains the value then just return the number
            if(map.containsKey(nums[i])){
                return nums[i];
            }
            //else put the value into the map
            else{
                map.put(nums[i],1);
            }
        }
        //if the array doesn't contains any duplicate then return -1;
        return -1;
    }
}
