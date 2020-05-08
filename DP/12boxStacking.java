class Geeks 
{
    static class Pair implements Comparable<Pair> {
		int l;
		int b;
		int h;
		int area;

		Pair(int l, int b, int h) {
			this.l = l;
			this.b = b;
			this.h = h;
			this.area = (l * b);
		}

		public int compareTo(Pair o) {
			return this.area - o.area;
		}
	}

	public static int maxHeight(int h[], int b[], int l[], int n) {

		ArrayList<Pair> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new Pair(l[i], b[i], h[i]));
			arr.add(new Pair(l[i], h[i], b[i]));
			arr.add(new Pair(b[i], l[i], h[i]));
			arr.add(new Pair(b[i], h[i], l[i]));
			arr.add(new Pair(h[i], l[i], b[i]));
			arr.add(new Pair(h[i], b[i], l[i]));
		}

		Collections.sort(arr);
		
		// LIS on arr i.e. l and b both are bigger then previous one
		int[] strg = new int[6 * n];
		strg[0] = arr.get(0).h;
		
		
		int res = strg[0];
		for (int i = 1; i < 6 * n; i++) {
			int l1 = arr.get(i).l;
			int b1 = arr.get(i).b;
			int h1 = arr.get(i).h;
			
			int maxh = 0;
			for(int j = i - 1; j >= 0; j--) {
				int l2 = arr.get(j).l;
				int b2 = arr.get(j).b;
				
				if(l1 > l2 && b1 > b2) {
					maxh = Math.max(maxh, strg[j]);
				}
			}
			strg[i] = maxh + h1;
			if(res < strg[i]) res = strg[i];
		}
		return res;
	}
}

