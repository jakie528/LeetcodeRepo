class Solution {
    //返回步数, different from the return true/false in Jump Game I
    public int jump(int[] nums) {
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for(int i = 0; i < n -1; i++) {
            curFar = Math.max(nums[i]+i, curFar);

            //collect the range of farthest untile the end 
            //of the current range
            if(i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        return answer;
    }
}