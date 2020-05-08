/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    static Scanner scn = new Scanner(System.in);
    
    static int numSquares(int[][] mat) {
        int max = 0;
        for(int i = mat.length - 1; i >= 0; i--) {
            for(int j = mat[0].length - 1; j >= 0; j--) {
                if(i == mat.length - 1 || j == mat[0].length - 1) {
                    if(mat[i][j] > max) max = mat[i][j];
                } else if(mat[i][j] == 1) {
                    mat[i][j] = Math.min(mat[i + 1][j + 1], 
                    Math.min(mat[i + 1][j], mat[i][j + 1])) + 1;
                    
                    if(mat[i][j] > max) max = mat[i][j];
                }
            }
        }
        return max;
    }
    
    static void input(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                mat[i][j] = scn.nextInt();
            }
        }
    }
    
	public static void main (String[] args) {
		int t = scn.nextInt();
		while(t > 0) {
		    int r = scn.nextInt();
		    int c = scn.nextInt();
		    
		    int[][] mat = new int[r][c];
		    input(mat);
		    int n = numSquares(mat);
		    System.out.println(n);
		    t--;
		}
	}
}
