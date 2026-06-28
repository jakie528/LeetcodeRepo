class Solution {
    public boolean isPalindrome(String s) {

      char[] c = s.toCharArray();
      int n = c.length;

      for(int i = 0, j = n-1; i < j; i++, j--) {
        while(i<j && !Character.isLetterOrDigit(s.charAt(i))) {
            i++;
        }
        while(i < j && !Character.isLetterOrDigit(s.charAt(j))) {
            j--;
        }
        if(Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j))) {
            return false;
        }
      }

      return true;
    }
}