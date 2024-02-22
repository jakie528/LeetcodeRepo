class Solution {
    public void sortColors(int[] nums) {
        //use a three-pointer to track the rightmost boundary of zeros,
        // the leftmost boundary of twos, and the current element under consideration.
        int p0 = 0;
        int i = 0;
        int p2 = nums.length-1;
        int tmp;

        while(i <= p2) {
            //swap with the num in p2
            if(nums[i] == 2 ) {
                tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            } 
            // swap nums[i] with nums[p0] 
            else if(nums[i] == 0) {
                tmp = nums[i];
                //nums[i] is assigned, then i is incremented by 1
                nums[i++] = nums[p0];
                nums[p0++] = tmp;
            } else {
                i++;
            }
        }
    }
}