// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true

// Example 2:
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

package Day35;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //runs a for loop to iterate over the rows in the matrix
        for(int i=0;i<matrix.length;i++){
            //find the length of the each row -1  and assign it to n
            int n=matrix[i].length-1;
            //check if our target less than equal to our last element of the row means our target is present in this row so now apply binary search to find the target element
            if(target<=matrix[i][n]){
                int start=0;
                int end=n;
                while(start<=end){
                    int mid=start+(end-start)/2;
                    if(target==matrix[i][mid]) return true;
                    if(target<matrix[i][mid])  
                       end=mid-1;
                    else
                       start=mid+1;
                }
            }
        }
        //if not found then return false
        return false;
    }
}
