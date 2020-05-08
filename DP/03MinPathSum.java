class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; // rows
        int n = grid[0].length; // columns
        
        int[][] strg = new int[m][n];
        
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(i == m - 1 && j == n - 1) {
                    strg[i][j] = grid[i][j];
                } else if(i == m - 1) {
                    strg[i][j] = strg[i][j + 1] + grid[i][j];
                } else if(j == n - 1) {
                    strg[i][j] = strg[i + 1][j] + grid[i][j];
                } else {
                    strg[i][j] = Math.min(strg[i + 1][j], strg[i][j + 1]) + grid[i][j];  
                }
            }
        }
        return strg[0][0];
    }
}
