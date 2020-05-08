/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    
    static void input(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }     
    }
    
    static int solve(int[] arr) {
        if(arr.length == 0) return 0;
        int inc = arr[0];
        int exc = 0;
        
        for(int i = 1; i < arr.length; i++) {
            int temp = inc;
            inc = exc + arr[i];
            exc = Math.max(temp, exc);
        }
        return Math.max(inc, exc);
    }
    
    static Scanner scn = new Scanner(System.in);
    
	public static void main (String[] args) {
	    int test = scn.nextInt();
	    while(test != 0) {
	        int len = scn.nextInt();
	        int[] arr = new int[len];
	        input(arr);
	        int ans = solve(arr);
	        System.out.println(ans);
	        test--;
	    }
	}
}
