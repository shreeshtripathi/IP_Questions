public class Solution {
    public int minCostII(int[][] costs) {
        int r = costs.length;
        if(r == 0) return 0;
        int c = costs[0].length;
        
        int[][] strg = new int[r][c];
        
        // fill first row 
        // make min and second min
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for(int i = 0; i < c; i++) {
            strg[0][i] = costs[0][i];
            if(strg[0][i] < min) {
                smin = min;
                min = strg[0][i];
            } else if(strg[0][i] < smin) {
                smin = strg[0][i];
            }
        }
        
        for(int i = 1; i < r; i++) {
            int nmin = Integer.MAX_VALUE;
            int nsmin = Integer.MAX_VALUE;
            for(int j = 0; j < c; j++) {
                if(strg[i - 1][j] == min) {
                    strg[i][j] = smin + costs[i][j];
                } else {
                    strg[i][j] = min + costs[i][j];
                }
                if(strg[i][j] < nmin) {
                    nsmin = nmin;
                    nmin = strg[i][j];
                } else if(strg[i][j] < nsmin) {
                    nsmin = strg[i][j];
                }
            }
            min = nmin;
            smin = nsmin;
        }
        
        int cost = Integer.MAX_VALUE;
        for(int j = 0; j < c; j++) {
            if(strg[r - 1][j] < cost) cost = strg[r - 1][j];
        }
        return cost;
    }
}
