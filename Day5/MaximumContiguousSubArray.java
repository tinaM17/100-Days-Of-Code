package Day5;

class Solution {
    public int maxSubArray(int[] nums) {
          int currSum=0;
       int maxSum=nums[0];
       
       for(int i=0;i<nums.length;i++){
           //step 1:- calculate the current sum of the subarray
           currSum+=nums[i];
           
           //step2:-check if the current sum is greater than max sum
           if(currSum>maxSum){
               //update the maxSum
               maxSum=currSum;
           }
           
           //step3:-if the current sum holds negative value then we discard this subarray
           if(currSum<0){
               //assign 0 to our currsum to discard the previous part
               currSum=0;
           }
       }
       return maxSum;
        
    }
}
