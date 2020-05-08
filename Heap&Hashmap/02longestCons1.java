class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int val : nums) {
            if(val == 0) {
                max = Math.max(count, max);
                count = 0;
            } else {
                count++;
            }
        }
        max = Math.max(count, max);
        return max;
    }
}
