// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Example 1:
// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

// Example 2:
// Input: heights = [2,4]
// Output: 4

package Day59;
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        //variable to store our maximum area
        int maxArea=0;
        //call the two methods and store it in a array
        int[] prevSmall=prevSmaller(heights);
        int[] nextSmall=nextSmaller(heights);

        //For loop to iterate over the heights array
        for(int i=0;i<heights.length;i++){
            //calculate the area of each heights by using this formula
            int area=(nextSmall[i]-prevSmall[i]-1)*heights[i];
            //update maxArea
            maxArea=Math.max(area,maxArea);
        }
        //finally return the maxArea
        return maxArea;
    }

    //Method to find previous smaller number, it returns a array which contain the previous smaller number index value
    public int[] prevSmaller(int[] heights){
          int[] ans=new int[heights.length];
          Stack<Integer> stack=new Stack<>();

          for(int i=0;i<heights.length;i++){
              while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                  stack.pop();
              }
              if(stack.isEmpty()){
                  ans[i]=-1;
              }
              else if(heights[stack.peek()]<heights[i]){
                  ans[i]=stack.peek();
              }
              stack.push(i);
          }
          return ans;
    }
    //Method to find next smaller number, it returns a array which contain the next smaller number index value
    public int[] nextSmaller(int[] heights){
         int[] ans=new int[heights.length];
          Stack<Integer> stack=new Stack<>();

          for(int i=heights.length-1;i>=0;i--){
              while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                  stack.pop();
              }
              if(stack.isEmpty()){
                  ans[i]=heights.length;
              }
              else if(heights[stack.peek()]<heights[i]){
                  ans[i]=stack.peek();
              }
              stack.push(i);
          }
          return ans;
    }

}