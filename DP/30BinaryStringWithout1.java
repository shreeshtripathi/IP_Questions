import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static int solve(int n) {
        if(n == 0) return 0;
        int zero = 1;
        int one = 1;
        int vr = 1000000007;
        
        for(int i = 1; i < n; i++) {
            int temp = zero;
            zero = (one + zero) % vr;
            one = temp;
        }
        return (one + zero) % vr;
    }
    
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while(test != 0) {
		    int len = scn.nextInt();
		    int ans = solve(len);
		    System.out.println(ans);
		    test--;
		}
	}
}
