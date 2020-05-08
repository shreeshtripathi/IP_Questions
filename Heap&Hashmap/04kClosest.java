class Solution {
    
    private class pair implements Comparable<pair>{
        int x;
        int y;
        int dist;
        
        pair(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (x * x) + (y * y);
        }
        
        public int compareTo(pair o) {
            return this.dist - o.dist;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for(int[] arr : points) {
            pq.add(new pair(arr[0], arr[1]));
        }
        
        int[][] ans = new int[k][2];
        k--;
        while(k >= 0) {
            pair rem = pq.remove();
            ans[k][0] = rem.x;
            ans[k][1] = rem.y;
            k--;
        }
        return ans;
    }
}
