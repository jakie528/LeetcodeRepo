class Solution {
    public boolean containsDuplicate(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      
      for(int i = 0; i < nums.length; i++){
         // the same key occur twice - duplicate
         // otherwise we store the pair
         if(map.containsKey(nums[i])) {
            return true;
         } else {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
         }
      }
      
      
         
      return false;
    }
}