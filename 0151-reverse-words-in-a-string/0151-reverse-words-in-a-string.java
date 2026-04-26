class Solution {
    public String reverseWords(String s) {
        // Remove leading and trailing space from a String
        String words = s.strip();
        char[] arr = words.toCharArray();
        int n = arr.length;

        // Step1: Reverse the entire Array
        reverse(arr, 0, n-1);

        // Step2: Reverse each word and compact the white space
        int i = 0;
        int writeIndex = 0;

        while(i < n){
        while(i < n && arr[i] == ' ') 
        i++;

        if(i == n) break;

        //white space before the word
        if(writeIndex > 0)
         arr[writeIndex++] = ' ';

         int wordStart = writeIndex;
         while(i < n && arr[i] != ' ') {
            arr[writeIndex++] = arr[i++];
         }

         // reverse the word in place
         reverse(arr, wordStart, writeIndex-1);
        }

        // new String(char[] value, int offset, int count)
        return new String(arr, 0, writeIndex);
        }
    

    private void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp; 
            start++;
            end--;
        }
    }
}