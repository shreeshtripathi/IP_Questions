/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static Scanner scn = new Scanner(System.in);
    
    static void input(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
    
    static void display(int[][] arr) {
        for(int[] a : arr) {
            for(int val : a) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    } 
    
    static int knapsack(int[] vals, int[] wts, int cap, int n) {
        int[][] strg = new int[n + 1][cap + 1];
        for(int r = 1; r <= n; r++) {
            int price = vals[r - 1];
            int wt = wts[r - 1];        
            
            for(int c = 1; c <= cap; c++) {
                if(c < wt) {
                    strg[r][c] = strg[r - 1][c];        
                } else {
                    strg[r][c] = Math.max(strg[r - 1][c], price + strg[r - 1][c - wt]);
                }
            }
        }
        // display(strg);
        return strg[n][cap];
    }
    
	public static void main (String[] args) {
		int t = scn.nextInt();
		while(t > 0) {
		    int n = scn.nextInt();
		    int cap = scn.nextInt();
		    int[] val = new int[n];
		    int[] wts = new int[n];
		    
		    input(val);
		    input(wts);
		    
		    int profit = knapsack(val, wts, cap, n);
		    System.out.println(profit);
		    t--;
		}
	}
}
