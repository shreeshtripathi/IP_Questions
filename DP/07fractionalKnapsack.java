/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	static Scanner scn = new Scanner(System.in);
    
    static void input(int[] vals, int[] wts) {
        for(int i = 0; i < vals.length; i++) {
            vals[i] = scn.nextInt();
            wts[i] = scn.nextInt();
        }
    }
    
    static class pair implements Comparable<pair>{
        int wt;
        int val;
        double ratio;
        
        pair(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.ratio = (val / (1.0 * wt));
        }
        
        public int compareTo(pair o) {
            if(this.ratio > o.ratio) {
                return 1;
            } else if(this.ratio == o.ratio) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
    static double knapsack(int[] vals, int[] wts, int cap, int n) {
           PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
           
           for(int i = 0; i < n; i++) {
               pq.add(new pair(vals[i], wts[i]));
           }
           
           double profit = 0;
           while(pq.size() > 0 && cap > 0) {
               pair rem = pq.remove();
            //   System.out.print(rem.ratio + " ");
               if(rem.wt <= cap) {
                   cap -= rem.wt;
                   profit += rem.val;
               } else {
                   profit += (rem.ratio * cap * 1.0);
                   cap = 0;
               }
           }
           return profit;
    }
    
	public static void main (String[] args) {
		int t = scn.nextInt();
		while(t > 0) {
		    int n = scn.nextInt();
		    int cap = scn.nextInt();
		    int[] val = new int[n];
		    int[] wts = new int[n];
		    
		    input(val, wts);
		    
		    double profit = knapsack(val, wts, cap, n);
		    System.out.println(String.format("%.2f", profit));
		    t--;
		}
	}
}
