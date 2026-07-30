class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // first run binary search on x column than on y column

        int lowerRow = 0;
        int upperRow = matrix.length - 1; // 2
        int currRow = lowerRow + ((upperRow - lowerRow) / 2); //1 // 2
        
        while (lowerRow <= upperRow) {
            
            if(matrix[currRow][0] == target) {
                return true;
            }
            if (matrix[currRow][0] > target) { // 1) 1 2)2
                upperRow = currRow - 1; 
            } else {
                lowerRow = currRow + 1; 
                
            }
            currRow = lowerRow + ((upperRow - lowerRow) / 2); // 1
        }
        if(upperRow < 0) {
            return false;
        }
        currRow = upperRow;
        System.out.println("Selected Row: " + currRow);

        int lowerCol = 0;
        int upperCol = matrix[0].length - 1; 
        int currCol = lowerCol + ((upperCol - lowerCol) / 2);
        while (lowerCol <= upperCol) {
            currCol = lowerCol + ((upperCol - lowerCol) / 2);
            if(matrix[currRow][currCol] == target) {
                return true;
            }
            
            if (matrix[currRow][currCol] > target) { // 1) 1 2)2
                upperCol = currCol - 1; // 2) 1
            } else {
                lowerCol = currCol + 1; //1) 2
                
            }
        }
        return false;
    }
}

//[[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 11