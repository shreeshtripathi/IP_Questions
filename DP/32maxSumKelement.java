// import java.util.*;

public class test {

    static int helper(int[] arr, int st, int end, int k) {
        int[][] inc = new int[k + 1][end - st + 1];
        int[][] exc = new int[k + 1][end - st + 1];

        for(int i = 1; i <= k; i++) {
            inc[i][0] = arr[st];
        }

        for(int i = 1; i <= k; i++) {
            for(int j = 1; j <= end - st; j++) {
                inc[i][j] = arr[st + j] + exc[i - 1][j - 1];
                exc[i][j] = Math.max(inc[i][j - 1], exc[i][j - 1]);
            }
        }
        return Math.max(inc[k][end - st], exc[k][end - st]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int ans = helper(arr, 0, arr.length - 1, 2);
        System.out.println(ans);
    }
}