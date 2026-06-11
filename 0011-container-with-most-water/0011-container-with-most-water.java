class Solution {
    public int maxArea(int[] height) {
        // move the shorter line inwards, despite the reduction in width
        //since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int area;
            //every container that pairs the current left with a moved-in right is both narrower and no taller — it can never beat the current area. 

            if(height[left] <= height[right]) {
                area = (right - left) * height[left]; 
                left ++;
            } else {
                area = (right - left) * height[right]; 
                right --;
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}