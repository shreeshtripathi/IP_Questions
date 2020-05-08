class Solution {
    
    public boolean canCross(int[] stones) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < stones.length; i++) 
            map.put(stones[i], i);
        
        
        int n = stones.length;
        boolean[][] strg = new boolean[n + 1][n];
        
        strg[1][0] = true;
        
        for(int j = 0; j < n; j++) {
            for(int i = 1; i < j + 2 && i < n; i++) {
                if(strg[i][j] == true) {
                    int jump = i;
                    int next = jump + stones[j];
                    if(map.get(next) != null) {
                        int col = map.get(next);
                        strg[jump - 1][col] = true;
                        strg[jump][col] = true;
                        strg[jump + 1][col] = true;
                    }
                }
            }
        }
        
        for(int j = 0; j < n; j++) {
            if(strg[j][n -1] == true) return true;
        }
        return false;
    }
}
