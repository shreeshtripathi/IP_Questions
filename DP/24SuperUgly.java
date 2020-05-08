class Solution {
    private class pair implements Comparable<pair>{
        int val;
        int indx;
        
        pair(int val, int indx) {
            this.val = val;
            this.indx = indx;
        }
        
        public int compareTo(pair o) {
            return this.val - o.val;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ptr = new int[len];
        
        int[] strg = new int[n];
        strg[0] = 1;
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
            pq.add(new pair(primes[i], i));
        }
        
        for(int i = 1; i < n; i++) {
            // get + remove
            pair rem = pq.remove();
            // update in storage
            strg[i] = rem.val;
            // update in pointer array
            ptr[rem.indx] =ptr[rem.indx] + 1;
            // push in priority queue
            pq.add(new pair(primes[rem.indx] * strg[ptr[rem.indx]], rem.indx));
            
            int data = rem.val;
            // check for same
            while(pq.peek().val == data) {
                pair rem2 = pq.remove();
                // update in pointer array
                ptr[rem2.indx] += 1;
                // push in priority queue
                pq.add(new pair(primes[rem2.indx] * strg[ptr[rem2.indx]], rem2.indx));
            }
        }
        return strg[n - 1];
    }
}
