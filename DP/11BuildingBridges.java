package DynamicProgramming;

import java.util.*;

public class buildingBridges {

	static class pair implements Comparable<pair>{
		int a;
		int b;
		
		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(pair o) {
			return this.a - o.a;
		}
	}
	
	static int lis(int[] N, int[] S) {
		// sort the north array and according to the pair 
		// sort south array too
		PriorityQueue<pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N.length; i++) {
			pq.add(new pair(N[i], S[i]));
		}
		
		for(int i = 0; i < S.length; i++) {
			S[i] = pq.remove().b;
		}
		
		System.out.println(Arrays.toString(S));
		// use LIS concept of logn
		lis cl = new lis();
		
		return cl.LIS(S);
		
	}
	
	public static void main(String[] args) {
		int[] N = {8, 1, 4, 3, 5, 2, 6, 7};
		int[] S = {1, 2, 3, 4, 5, 6, 7, 8};
		 
        
		
		int maxBridges = lis(N, S);
		System.out.println(maxBridges);
	}

}

