// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

package Day21;

class Solution {
    public int maxArea(int[] height) {
        //initialize our two pointer i=0 and j=n-1;
        int i=0;
        int j=height.length-1;
        //also initialize our max water contain
        int maxWater=0;
        //while i less than j means there exists a container continue the loop
        while(i<j){
           //To check our current water contains btw i and j height we have find which height is minimum btw them and then multiply with their distance i,e; (j-i).
           int water=Math.min(height[i],height[j])*(j-i);
           //If our current water contain is greater than max then update it
           maxWater=Math.max(maxWater,water);
           //Now if the i th height is greater than j then we have to decrement our j to perform our next iteration
           if(height[i]>=height[j]){
               j--;
           }
           //else we have to increment our i value to check for the second container
           else {
               i++;
           }
        }
        //Now return our max value
        return maxWater;
    }
}
