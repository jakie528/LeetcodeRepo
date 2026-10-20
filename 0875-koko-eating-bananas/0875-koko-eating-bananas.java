class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find the minimum k
        int k = 0; //speed 
        int left = 1;
        int right = 1;
        for(int pile : piles) {
            // h >= piles.length
          right = Math.max(pile, right);
        }

        while(left < right) {
            int mid = left + (right- left)/2;
            int hour = 0;

            for(int pile : piles) {
                hour += Math.ceil((double) pile / mid);
            }
            // check the middle is a workable speed
            if(hour <= h) { // decrease the speed
                right = mid;
            } else {  
                left = mid + 1;
            }
        }
        return left;
    }
}