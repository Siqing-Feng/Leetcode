class Solution {
	public int sumSubarrayMins(int[] A) {
        int MOD = (int)1e9 + 7;
		int res=0;
		LinkedList<Integer> s=new LinkedList<>();
		s.push(-1);
		for(int i=0; i<A.length; i++) {
			while(s.size()>1 && A[i]<A[s.peek()]) {
				int idx=s.pop();
				int left=idx-s.peek();
				int right=i-idx;
				res+=(left*right*A[idx]);
                res%=MOD;
			}
			s.push(i);
		}
		while(s.size()>1) {
			int idx=s.pop();
			int left=idx-s.peek();
			int right=A.length-idx;
			res+=(left*right*A[idx]);
            res%=MOD;
		}
		return res;
	}
}