// Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

// Example 1:


// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 6
// Explanation: The maximal rectangle is shown in the above picture.
// Example 2:

// Input: matrix = [["0"]]
// Output: 0
// Example 3:

// Input: matrix = [["1"]]
// Output: 1

package Day60;
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        //Create an 1D array of size equal to the column size of the matrix 
        int[] curRow=new int[matrix[0].length];
        //Run a for loop for the first row of the matrix 
        for(int i=0;i<matrix[0].length;i++){
            //As our currRow array is a int, and our given matrix is char so we have to change it from char to int before adding to the value
            curRow[i]=Integer.parseInt(String.valueOf(matrix[0][i]));
        }
        //After the for loop we have successfully added our first row into the curRow array. Now this is the similar problem to the largest Rectangle Area of an array. So we create a logic of that and call the function it will return the largest Area of the given row. 
        
        //store the value in maxArea variable
        int maxRectangle=largestRectangleArea(curRow);

        //Now for the next rows we have to run two for loops to iterate over the matrix
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //Now for the next row values we have to check if it contains '1' then we have to add 1 in our curRow array index j; else put 0 in the j index of curRow.
                if(matrix[i][j]=='1'){
                    curRow[j]+=1;
                }
                else {
                    curRow[j]=0;
                }
            }
            //After updating the curRow with the next row values of the matrix we have to again call our largestRectangleArea() method to find the maxArea of this row. And then update our maxRectangle with the maximum value
            int currArea=largestRectangleArea(curRow);
            maxRectangle=Math.max(currArea,maxRectangle);
        }
        //finally when all rows are done we have to return our maxRectange area
        return maxRectangle;
    }
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
