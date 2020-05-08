class Solution {
    public boolean isMatch(String str, String pat) {
        if(pat.length() == 0 && str.length() == 0) return true;
        if(pat.length() == 0) return false;
        int s = str.length() + 1;
        int p = pat.length() + 1;
        boolean[][] strg = new boolean[p][s];
        
        for(int i = 0; i < p; i++) {
            for(int j = 0; j < s; j++) {
                if(i == 0 && j == 0) {
                    strg[i][j] = true;
                } else if(i == 0) {
                    strg[i][j] = false;
                } else if(j == 0) {
                    if(pat.charAt(i - 1) == '*') {
                        strg[i][j] = strg[i - 1][j];
                    }
                } else {
                    if(str.charAt(j - 1) == pat.charAt(i - 1) || 
                      pat.charAt(i - 1) == '?') {
                        strg[i][j] = strg[i - 1][j - 1];
                    } else if(pat.charAt(i - 1) == '*') {
                        strg[i][j] = strg[i - 1][j] || strg[i][j - 1];
                    }
                }
            }
        }
        
        return strg[p - 1][s - 1];
    }
}
