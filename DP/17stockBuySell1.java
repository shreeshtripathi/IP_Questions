class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        
        int lgr = prices[prices.length - 1];
        int profit = 0;
        
        for(int i = prices.length - 2; i >= 0; i--) {
            int cprof = lgr - prices[i];
            if(cprof > profit) profit = cprof;
            
            if(prices[i] > lgr) lgr = prices[i];
        }
        
        return profit;
    }
}
