public class Solution {
    public int minCost(int[][] costs) {
        int r = costs.length;
        if(r == 0) return 0;
        int c = costs[0].length;
        
        int[][] strg = new int[r][c];
        
        // fill first row 
        for(int i = 0; i < c; i++) {
            strg[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(j == 0) {
                    strg[i][j] = Math.min(strg[i - 1][j + 1], strg[i - 1][j + 2]) + costs[i][j];
                } else if(j == 1) {
                    strg[i][j] = Math.min(strg[i - 1][j - 1], strg[i - 1][j + 1]) + costs[i][j];
                } else {
                    strg[i][j] = Math.min(strg[i - 1][j - 2], strg[i - 1][j - 1]) + costs[i][j];
                }
            }
        }
        return Math.min(strg[r - 1][0], Math.min(strg[r - 1][1], strg[r - 1][2]));
    }
}
