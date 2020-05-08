package DynamicProgramming;

public class maxSumAlternatingSubseq {

	private static int maxSum(int[] arr) {
		int n = arr.length;
		int[] dec = new int[n];
		int[] inc = new int[n];
		
		dec[n - 1] = arr[n - 1];
		inc[n - 1] = arr[n - 1];
		for(int i = n - 2; i >= 0; i--) {
			int val = arr[i];
			int sum = 0;
			// fill decreasing
			for(int j = i + 1; j < n; j++) {
				if(arr[j] > val) {
					sum = Math.max(sum, inc[j]);
				}
			}
			dec[i] = sum + val;
			sum = 0;
			// fill increasing
			for(int j = i + 1; j < n - 1; j++) {
				if(arr[j] < val) {
					sum = Math.max(sum, dec[j]);
				}
			}
			inc[i] = sum + val;
		}
		
 		return inc[0];
	}
	
	public static void main(String[] args) {
		int arr[]= {8, 2, 3, 5, 7, 9, 10};
		
		System.out.println(maxSum(arr));
	}

}

