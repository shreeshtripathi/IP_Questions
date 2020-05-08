class Solution {
    public int maximalSquare(char[][] mat) {
        int max = 0;
        int r = mat.length;
        if(r == 0) return 0;
        int c = mat[0].length;
        int[][] strg = new int[r][c];
        
        for(int i = r - 1; i >= 0; i--) {
            for(int j = c - 1; j >= 0; j--) {
                if(i == r - 1 || j == c - 1) {
                    if(mat[i][j] == '1') {
                        strg[i][j] = 1;
                    }
                } else if(mat[i][j] == '1') {
                    strg[i][j] = Math.min(strg[i + 1][j + 1], 
                    Math.min(strg[i + 1][j], strg[i][j + 1])) + 1;
                }
                if(strg[i][j] > max) max = strg[i][j];
            }
        }
        return max * max;
    }
}
