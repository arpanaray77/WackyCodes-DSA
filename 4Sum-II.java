class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    
     int count = 0;

    HashMap<Integer, Integer> twosum= new HashMap<>();

    for (int i : nums1) {

        for (int j : nums2) {
            int sum = i + j;
          twosum.put(sum, twosum.getOrDefault(sum, 0) + 1);

        }
    }

    for (int k : nums3) {

        for (int l : nums4) {
            int sum = k + l;

            if (twosum.containsKey(-sum)) {
                count += twosum.get(-sum);
            }
        }
    }

    return count;
   }
}