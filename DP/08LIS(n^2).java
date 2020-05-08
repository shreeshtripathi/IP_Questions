class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] strg = new int[nums.length];
        strg[0] = 1;
        
        int maxlen = 1;
        for(int i = 1; i < nums.length; i++) {
            int len = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j] && len < strg[j]) {
                    len = strg[j];
                }
            }
            strg[i] = len + 1;
            if(strg[i] > maxlen) maxlen = strg[i];
        }
        return maxlen;
    }
}
