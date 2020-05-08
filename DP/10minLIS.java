package DynamicProgramming;
import java.util.*;

public class minLIS {

	static int getIndx(ArrayList<Integer> list, int val) {
		int lo = 1;
		int hi = list.size() - 1;
		
		int idx = -1;
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(list.get(mid) > val) {
				// that means more smaller value is present in right
				lo = mid + 1;
			} else {
				// potential answer is mid but continue toward left
				idx = mid;
				hi = mid - 1;
			}
		}
		return idx;
	}
	
	static int LDS(int[] arr, int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MAX_VALUE);
		list.add(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int jsi = getIndx(list, val);
			if(jsi == -1) {
				list.add(val);
			} else {
				list.set(jsi, val);
			}
		}
		return list.size() - 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 6, 2, 4, 3};
		int res = LDS(arr, arr.length);
		System.out.println(res);
	}

}

