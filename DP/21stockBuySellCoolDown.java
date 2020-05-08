class Solution {
    public int maxProfit(int[] p) {
        int n = p.length;
        if(n == 0 || n == 1) return 0;
        
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = -p[0];
        buy[1] = Math.max(-p[0], -p[1]);
        
        sell[0] = 0;
        sell[1] = Math.max(p[1] + buy[0], sell[0]);
        
        for(int i = 2; i < n; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - p[i]);
            sell[i] = Math.max(sell[i - 1], buy[i] + p[i]);
        }
        return sell[n - 1];
    }
}
