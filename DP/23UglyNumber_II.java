class Solution {
    
    private int largest(int[] strg, int p2, int p3, int p5) {
        int two = 2 * strg[p2];
        int three = 3 * strg[p3];
        int five = 5 * strg[p5];
        
        if(two < three && two < five) {
            return 2;
        } else if(three < five) {
            return 3;
        } else {
            return 5;
        }
    }
    
    public int nthUglyNumber(int n) {
        int[] strg = new int[n + 1];
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        
        strg[1] = 1;
        HashSet<Integer> h = new HashSet<>();
        h.add(1);
        
        for(int i = 2; i <= n; i++) {
            int ptr = largest(strg, p2, p3, p5);
            
            if(ptr == 2) {
                if(h.contains(2 * strg[p2])) {
                    p2++;
                    i--;
                } else {
                    h.add(2 * strg[p2]);
                    strg[i] = 2 * strg[p2];
                    p2++;   
                }
            } else if(ptr == 3) {
                if(h.contains(3 * strg[p3])) {
                    p3++;
                    i--;
                } else {
                    h.add(3 * strg[p3]);
                    strg[i] = 3 * strg[p3];
                    p3++;   
                }
            } else if(ptr == 5) {
                if(h.contains(5 * strg[p5])) {
                    p5++;
                    i--;
                } else {
                    h.add(5 * strg[p5]);
                    strg[i] = 5 * strg[p5];
                    p5++;   
                }
            }
        }
        System.out.println(Arrays.toString(strg));
        return strg[n];
    }
}
