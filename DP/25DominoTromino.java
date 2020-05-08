class Solution {
    public int numTilings(int n) {
        if(n == 0) {
            return 0;   
        } else if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        
        long[] strg = new long[n + 1];
        strg[0] = 1;
        strg[1] = 1;
        strg[2] = 2;
        
        long num = 1000000007;
        for(int i = 3; i <= n; i++) {
            strg[i] = ((2 * strg[i - 1]) + strg[i - 3]) % num;
        }
        
        return (int)strg[n];
    }
}
