// Given a 2D integer array matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]
// Example 2:

// Input: matrix = [[1,2,3],[4,5,6]]
// Output: [[1,4],[2,5],[3,6]]

package Day41;

class Solution {
    public int[][] transpose(int[][] matrix) {
        //create an empty matrix of size m*n, means row becomes our new matrix columns and column becomes our new matrix row
        int[][] ans=new int[matrix[0].length][matrix.length];
        //initialize our row and col variable to 0 for traversing the new matrix
        int row=0,col=0;
        //traverse the entire matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                //put the value of matrix(i,j) in ans(row,col)
                ans[row][col]=matrix[i][j];
                //increase row by 1
                row++;
                //check if the current row value is equal to the total row value of the new matrix then we have to move to our 2nd col to store the value so col++ and also point to our row to the first so row=0;
                if(row==ans.length){
                    row=0;
                    col++;
                }
            }
        }
        // return the ans matrix
        return ans;
    }
}
