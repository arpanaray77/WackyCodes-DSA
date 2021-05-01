class Solution {
    public int trap(int[] height) {
        int n=height.length;
            
          return getWater(height,n);
    }
    
    public int getWater(int h[],int n)
    {
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        if(n==0)
            return 0;
        lmax[0]=h[0];
        for(int i=1;i<n;i++)
        {
            lmax[i]=Math.max(lmax[i-1],h[i]);
        }
        rmax[n-1]=h[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rmax[i]=Math.max(rmax[i+1],h[i]);
        }
        
        int wt=0;
        for(int i=0;i<n;i++)
        {
            wt+=Math.min(lmax[i],rmax[i])-h[i];
        }
        return wt;
    }
}