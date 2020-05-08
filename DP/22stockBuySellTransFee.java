class Solution {
    public int maxProfit(int[] p, int fee) {
        int n = p.length;
        if(n == 0 || n == 1) return 0;
        
        int buy = -p[0];
        int sell = 0;
        
        for(int i = 1; i < n; i++) {
            buy = Math.max(sell - p[i], buy);
            sell = Math.max(p[i] + buy - fee, sell);
        }
        return sell;
    }
}
