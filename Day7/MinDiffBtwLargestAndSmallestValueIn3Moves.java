package Day7;

import java.util.*;

class Solution {
    public int minDifference(int[] nums) {
        int n=nums.length;
        //Step-1:If our array size less than or equal to 4 then we can simply change the 3 values and the difference between them will always 0, so no need of further calculation
        if(n<=4)
           return 0;
        //Step-2:but if our array size>4 then we have to sort our array first, because by this we can get our smallest number in first index and largest in the n-1 index;
        Arrays.sort(nums);
 
        //Step3:- we have 3 moves, so we have 4 options to modify our array in such a way that the difference btw then will be minimum.
        //Option1:- Kill the 3 largest element from the end so now our minDiff1 becomes,
        int minDiff1 = nums[n-4]-nums[0];

        //Option2:- Kill the 2 largest+1 smallest element from the array so now our minDiff2 becomes,
        int minDiff2 = nums[n-3]-nums[1];

        //Option3:- Kill the 1 largest+ 2 smallest element from the array so now our minDiff3 becomes,
        int minDiff3 = nums[n-2]-nums[2];

        //Option4:- Kill the 3 smallest element from the array so now our minDiff4 becomes,
        int minDiff4 = nums[n-1]-nums[3];

        //Step4:- find the minimum value of this 4 difference and return the answer
        int result=Math.min(minDiff4,Math.min(minDiff3,Math.min(minDiff2,minDiff1)));
       
       return result;
    }
}