class Solution {
    
    private int getIndex(ArrayList<Integer> list, int data) {
		int idx = -1;
		int lo = 1;
		int hi = list.size() - 1;
		
		while(lo <= hi) {
			int mid = (lo + hi) / 2;
			
			// move right side if target is greater
			// otherwise mark mid as answer and find in right side
			if(list.get(mid) < data) {
				lo = mid + 1;
			} else {
				idx = mid;
				hi = mid - 1;
			}
			
		}
		return idx;
	}
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(Integer.MAX_VALUE);
		list.add(nums[0]);
		
		for(int i = 1; i < nums.length; i++) {
			int val = nums[i];
			int jgi = getIndex(list, val); // just greater index
			if(jgi == -1) {
				list.add(val);
			} else {
				list.set(jgi, val);
			}
		}
		
		return list.size() - 1;
    }
}
