class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        
        for(int val : nums) {
            sum += val;
            if(map.containsKey(sum - k) == true) {
                count += map.get(sum - k);
            }
            if(map.containsKey(sum) == true) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
}
