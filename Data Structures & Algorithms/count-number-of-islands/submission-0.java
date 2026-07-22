class Solution {

    private static final int [][] directions = {{1,0}, {-1,0}, {0,1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;

        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                if(grid[x][y] == '1') {
                    dfsHelper(x, y, grid);
                    count++;
                }
            }

        }
        return count;
    }

    private void dfsHelper(int x, int y, char[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }

        for (int[] coord : directions) {
            grid[x][y] = '0';
            dfsHelper(x + coord[0], y + coord[1], grid);
        }

    }
}
