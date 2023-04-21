//  Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2


package Day12;

class Solution {
    public int majorityElement(int[] nums) {

        int ansIndex=0;
        int count=1;
        //runs a for loop from 1 to n-1 because our ansIndex is on 0th position,so we have check from 1st index;
        for(int i=1;i<nums.length;i++){
            //Check if the current index element=ansTndex element then count+1
            if(nums[i]==nums[ansIndex])
               count++;
            else 
            //else we have to decrement our count by 1
                count--;
            //now if the count=0 then our answer maybe not the ansIndex element so we have update our ansIndex with the current index and set it's count as 1
            if(count==0){
                ansIndex=i;
                count=1;
            }
        }
        //Now we have to that our ansIndex element's total frequency is greater than equal to n/2 or not.So we have run a for loop again to check it's frequency
        //set count=0 because if we not set 0 then when we increment our count var then it will add the previous count also
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[ansIndex]){
               count++;
            }
        }
        //After getting the frequency we have check it is greater than equal to n/2 or not. if equal then return the number else return -1;
        if(count>nums.length/2)
           return nums[ansIndex];
        
        return -1;
    }
}
