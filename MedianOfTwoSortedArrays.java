class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int p1= 0, p2= 0; //current indices of array nums1 and nums2 respectively
        double mid1 = 0.0,mid0=0.0; //to store the two middle elements of sorted array


        for(int i=0;i<=(n1+n2)/2;i++)
        { 
            //comparing the elements of two arrays to get mid elements
            mid0=mid1;
            if(p1!=n1 && p2!=n2)
            {
                mid1=(nums1[p1]<nums2[p2])?nums1[p1++]:nums2[p2++]; 
            }
            else  if(p1<n1) 
            {
               mid1=nums1[p1++];
            }
            else
            {
                mid1=nums2[p2++];
            }
        }
        //if n1+n2 is odd,median=mid element (of sorted merged array) else median =average of two mid              elements
        if((n1+n2)%2==1)
          return (mid1);
        else
          return ((mid1+mid0)/2);
    }
}