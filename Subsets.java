class Solution {
   public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>(); //list for holding all subsets
    Arrays.sort(nums); 
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    
        list.add(new ArrayList<>(tempList)); //adding the subset in subsets list
    
    for(int i = start; i < nums.length; i++){ //finding all the subsets starting with element at ith index
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1); //including next element in subset
        tempList.remove(tempList.size() - 1); //removing the last element from subset for next iteration
    }
   }
}