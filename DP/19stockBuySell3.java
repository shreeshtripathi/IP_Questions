class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        
        int[] mpro = new int[prices.length];
        int max = 0;
        
        int n = prices.length;
        max = prices[n - 1];
        mpro[n - 1] = 0;
        
        for(int i = n - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            mpro[i] = Math.max(max - prices[i], mpro[i + 1]);
        }
        
        int min = prices[0];
        int minval = 0;
        max = mpro[0]; // now max is use as total profit
        for(int i = 1; i < n; i++) {
            min = Math.min(min, prices[i]);
            minval = Math.max(prices[i] - min, minval);
            
            max = Math.max(max, mpro[i] + minval);
        }
        
        
        return max;
    }
}
