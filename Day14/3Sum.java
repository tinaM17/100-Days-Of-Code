// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

 

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.
// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.
// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

package Day14;
import java.util.*;

class Solution {
    //declare a global List of List variable to access it anywhere
    List<List<Integer>> res=new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array
        Arrays.sort(nums);
        //now runs a for loop from 0 to n-3 because this is our i and j and k will be last two elements
        for(int i=0;i<nums.length-2;i++){
            //check if this is the first element or the previous element is not equal to the current element then enter the for loop
            //we are checking this loop to remove the duplicate value of a
            if(i==0 || nums[i-1]!=nums[i]){
                //call the twoSum function and send parameter as the array, the i+1th postion that's works as j and the -a value because if the two sum of j,k is equal to -a then the total sum will be 0.
                  twoSum(nums,i+1,-nums[i]);
            }
        }

        //return the list of list array
        return res;

    }
    public void twoSum(int nums[],int i,int x){
        //here our k=j and it points to the last element of the array
        int j=nums.length-1;
        //a will be the previous number of the i
        int a=nums[i-1];
        //while i less than j continue
        while(i<j){
           //check if the two sum of i and j will be equal to the -a then
           if(nums[i]+nums[j]==x){
               //declare a arraylist and put the 3 sum elements into the aaraylist
               List<Integer> sum=new ArrayList<>();
               sum.add(a);
               sum.add(nums[i]);
               sum.add(nums[j]);
               //now add this arraylist to our main res list
               res.add(sum);
               //now if the i,i+1 element is same then we have to remove the duplicate i or b.so increment i
               //duplicate b
               while(i<j && nums[i]==nums[i+1]) i++;
               //now if the j,j-1 element is same then we have to remove the duplicate j or c.so decrement j
               //duplicate c
               while(i<j && nums[j]==nums[j-1]) j--;
               //increment i and decrement j to check for 2nd iteration
               i++;
               j--;
               
           }
           //else if 2sum is greater than -a then we have to decrement j
           else if(nums[i]+nums[j]>x){
               j--;
           }
           //else if 2sum is smaller than -a then we have to increment i
           else
              i++;
        }
    }
}


