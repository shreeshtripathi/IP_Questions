class Solution {
    public int numRabbits(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0;
        
        for(int val : arr) {
            if(map.containsKey(val + 1) == true) {
                if(map.get(val + 1) < val + 1) {
                    map.put(val + 1, map.get(val + 1) + 1);    
                } else {
                    count += val + 1;
                    map.put(val + 1, 1);
                }
                
            } else {
                map.put(val + 1, 1);
                count += val + 1;
            }
        }
        return count;
    }
}
