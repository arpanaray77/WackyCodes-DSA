class Solution {
    public int maxArea(int[] arr) {

        int n=arr.length;
         if(n<=1)
             return 0;
        if(n==2)
            return Math.min(arr[0],arr[1]);
        
        //take two pointers (on both endpoints of array)
        int left=0;
        int right=n-1;
        int maxWater=0;
        
        //max water between two pointers = min of pointer elements * difference of pointer positions(i.e, l*b)
        while(left!=right)
        {
            maxWater=Math.max(maxWater,Math.min(arr[left],arr[right])*(right-left));
            //traversing from the pointer having lower values
            if(arr[left]<arr[right]) 
                   left++; 
            else
                right--;
        }
        
        return maxWater;
	}
}
