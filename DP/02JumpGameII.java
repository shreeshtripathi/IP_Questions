class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] strg = new int[n];
        
        strg[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            int jumps = nums[i];
            int min = n + 1;
            for(int j = i + 1; j <= i + jumps && j < n; j++) {
                min = Math.min(strg[j], min);
            }
            strg[i] = min + 1;
        }  
        return strg[0];
    }
}
