class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        
        List<List<Integer>> res= new ArrayList<>();
        
         if(arr.length<3)
            return res;
        
		// sort array elements
		Arrays.sort(arr);
        int n=arr.length;
        int sum=0;
        
		for (int i = 0;	i < n - 1; i++) {
			// initialize left and right
			int l = i + 1;
			int r = n - 1;
			int x = arr[i];
			while (l < r) {
				if (x + arr[l] + arr[r] == sum ) {
					// print elements if it's
					// sum is given sum.
                    List<Integer> lis=new ArrayList<>();
                    lis.add(x);
                    lis.add(arr[l]);
                    lis.add(arr[r]);
                    if(!(res.contains(lis)))
			            res.add(lis);
					l++;
					r--;
				}

				// If sum of three elements
				// is less than 'sum' then
				// increment in left to increase the sum
				else if (x + arr[l] + arr[r] < sum)
					l++;

				// if sum is greater than
				// given sum, then decrement
				// in right side to decrease the sum
				else
					r--;
			}
		}
    return res;
   }
}