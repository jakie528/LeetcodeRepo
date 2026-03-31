class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] answer = new int[n];

        for(int[] booking : bookings) {
            int firstFlight = booking[0];
            int lastFlight = booking[1];
            int seatCount = booking[2];

            answer[firstFlight-1] += seatCount;

            if(lastFlight < n){
                answer[lastFlight] -= seatCount;
            }
        }

        for(int i = 1; i < n; i++) {
            answer[i] += answer[i-1];
        }

        return answer;
    }
}