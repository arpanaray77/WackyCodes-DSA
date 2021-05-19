class Solution {
   public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> hset=new HashSet();
        
        Arrays.sort(nums); //sorting 
        
        for(int i=0; i<nums.length-3; i++){
            
            for( int j=i+1;j<nums.length-2; j++){
            int l=j+1;
            int r=nums.length-1;
            
            while(l<r){
                int sum=nums[i]+nums[j]+nums[l]+nums[r];
                if(sum == target)
                    hset.add(Arrays.asList(nums[i],nums[j],nums[l++],nums[r--]));//hashset for no duplicate quads
                
                else if(sum>target)
                    r--;
                else if(sum<target)
                   l++;   
            }   
          }
    }
   return new ArrayList<>(hset);
    }
}
