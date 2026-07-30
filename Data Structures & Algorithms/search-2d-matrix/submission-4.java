class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lowerRow = 0;
        int upperRow = matrix.length - 1;
        int currRow = lowerRow + ((upperRow - lowerRow) / 2);
        
        while (lowerRow <= upperRow) {
            if(matrix[currRow][0] == target) {
                return true;
            }
            if (matrix[currRow][0] > target) {
                upperRow = currRow - 1; 
            } else {
                lowerRow = currRow + 1; 
            }
            currRow = lowerRow + ((upperRow - lowerRow) / 2);
        }

        // FIX: use upperRow, not currRow
        if (upperRow < 0) {
            return false;
        }
        currRow = upperRow;

        int lowerCol = 0;
        int upperCol = matrix[0].length - 1; 
        int currCol = lowerCol + ((upperCol - lowerCol) / 2);
        while (lowerCol <= upperCol) {
            currCol = lowerCol + ((upperCol - lowerCol) / 2);
            if(matrix[currRow][currCol] == target) {
                return true;
            }
            
            if (matrix[currRow][currCol] > target) {
                upperCol = currCol - 1;
            } else {
                lowerCol = currCol + 1;
            }
        }
        return false;
    }
}