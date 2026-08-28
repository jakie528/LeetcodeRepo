class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        // 10km per liter
        // 5 liters used up, 1 liters of fuel will be transfered from the additional tank to the main tank.
        // how many times : mainTank -= 5 && additional tank >=1
        int times = 0;
        int distance = 0;
        
        while(additionalTank >= 1 && mainTank >=5 ) { // additionalTank = 2 && mainTank = 9
            mainTank = mainTank - 5 + 1;  // 1
            additionalTank -= 1; // 0
            times++; //2
        } 

        //if maintank < 5 || additionalTank < 1
        distance =  (5 * times + mainTank) * 10; // (5*2 + 1 ) * 10

        return distance;




        
        
    }
}