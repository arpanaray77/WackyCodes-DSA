class Solution {
    public int[] searchRange(int[] nums, int ele) {
        int pos1=-1,pos2=-1;
        int l=0,h=nums.length-1;
        
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(nums[mid]==ele)
            {
                pos1=pos2=mid;
                for(int i=mid-1;i>=0;i--) //searching lhs for first occurrence
                {
                    if(nums[i]==ele)
                        pos1=i;
                }
                for(int i=mid+1;i<=h;i++)//searching rhs for first occurrence
                {
                    if(nums[i]==ele)
                        pos2=i;
                }
                break;
            }
            else if(nums[mid]<ele)
            {
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        int res[]={pos1,pos2};
        return res;
    }
}