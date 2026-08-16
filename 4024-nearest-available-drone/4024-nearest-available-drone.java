class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        // calculate the distance between drone and target
        // |drone[i][0] -target[0]|+|drone[i][1] -target[1]| = distance
        // distance < drone[i][2] ? record the index
        // if not, continue.
        // return -1
       // drones = [[2,1,5],[4,4,5],[6,6,8]], target = [5,5]
        int n = drones.length; //3
        int res = -1;
        // int[] dis = new int[n];
        int smallestDistance = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            // i= 0: |2-5| + |1-5| = 7
            // i = 1: |4-5| + |4-5| = 2
            // i = 2: |6-5| + |6-5| = 2
            int distance = Math.abs(drones[i][0] - target[0]) + Math.abs(drones[i][1] - target[1]);
            // if the distance is within the range , find the smallest distance
            if(distance <= drones[i][2] && distance < smallestDistance) {
                smallestDistance = distance;
                res = i;   
            } 
        }
        return res;


        // // find the index of smallest distance to drone
        // for(int i = 0; i < n; i++) { //dis = [-1, 2, 2]
        //     if(dis[i] != -1 && (dis[i] < x)) {
        //             x = dis[i];  // 2
        //             res = i; // 1
        //     }
        // }

    }
}