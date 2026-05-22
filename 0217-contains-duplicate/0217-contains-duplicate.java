class Solution {
    public boolean containsDuplicate(int[] nums) {
      Set<Integer> set = new HashSet<>();
      
      for(int i = 0; i < nums.length; i++){
         // the same element occur twice - duplicate
         // otherwise we add the element to the set
         if(set.contains(nums[i])) {
            return true;
         } else {
            set.add(nums[i]);
         }
      }
      
      
         
      return false;
    
    }
}