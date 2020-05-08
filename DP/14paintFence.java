public class Solution {
    
    public int numWays(int n, int k) {
        int first = 0;
        int second = k;
        
        while(n - 1 > 0) {
            int temp_first = second;
            int temp_second = (first + second) * (k - 1);
            
            first = temp_first;
            second = temp_second;
            n--;
        }
        return first + second;
    }
}
