package Day29;


//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//LeetCode Link
//https://leetcode.com/problems/spiral-matrix/description/

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowS = 0;
        int rowE = matrix.length - 1;
        int colS = 0;
        int colE = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();
        
        while(rowS <= rowE && colS <= colE) {
            // covering one row, traversing from left to right in latest row...
            for(int i=colS; i<=colE; i++) {
                spiral.add(matrix[rowS][i]);
            }
            // updating starring row...
            rowS++;
            
            // covering one column, traversing from top to bottom in latest colum...
            for(int i=rowS; i<=rowE; i++) {
                spiral.add(matrix[i][colE]);
            }
            // updating ending colum...
            colE--;
            
            if(rowS <= rowE) {
                // covering one row, traversing from right to left in latest ending row...
                for(int i=colE; i>=colS; i--) {
                    spiral.add(matrix[rowE][i]);
                }
                // updating ending row...
                rowE--;
            }
            
            if(colS <= colE) {
                // convering one colum, trabersing from bottom to top in starting colum...
                for(int i=rowE; i>=rowS; i--) {
                    spiral.add(matrix[i][colS]);
                }
                // updating starting colum...
                colS++;
            }
        }
        return spiral;
    }
}
