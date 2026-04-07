class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length-1;
        int l = 0;
        int r = n;
        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            } else if (arr[mid] > arr[mid + 1]){
                r = mid;
            }           
        }
        return l;
    }
}