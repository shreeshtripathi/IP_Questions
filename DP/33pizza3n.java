class Solution {
    
    private int helper(int[] arr, int st, int end, int k) {
        int[][] inc = new int[k + 1][end - st + 1];
        int[][] exc = new int[k + 1][end - st + 1];

        for(int i = 1; i <= k; i++) {
            inc[i][0] = arr[st];
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= end - st; j++) {
                inc[i][j] = arr[st + j] + exc[i - 1][j - 1];
                exc[i][j] = Math.max(inc[i][j - 1], exc[i][j - 1]);
            }
        }
        return Math.max(inc[k][end - st], exc[k][end - st]);
    }
    
    public int maxSizeSlices(int[] slices) {
        int k = slices.length / 3;
        if(k == 1) {
            return Math.max(slices[0], Math.max(slices[1], slices[2]));
        }
        int ans1 = slices[0] + helper(slices, 2, slices.length - 2, k - 1);
        int ans2 = helper(slices, 1, slices.length - 1, k);
        
        return Math.max(ans1, ans2);
    }
}
