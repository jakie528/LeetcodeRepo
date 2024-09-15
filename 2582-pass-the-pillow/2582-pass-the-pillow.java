class Solution {
    public int passThePillow(int n, int time) {
        int remain = time % (2*n-2);
        if(remain < n) {
            return remain+1;
        }
        if(remain >= n) {
            remain = n-remain % n-1;
        }
        
        return remain;
        
    }
}