class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = s.length();

        while(index < n && s.charAt(index) == ' '){
            index++;
        }
        if(index < n && s.charAt(index) == '+'){
            sign = 1;
            index++;
        } else if(index < n && s.charAt(index) == '-'){
            sign = -1;
            index++;
        }

        // Traverse next digits of s and stop if it's not a digit
        while(index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // check overflow condition
            // currentResult*10 + digit < Integer.MAX_VALUE
            //Maximum positive: 2,147,483,647

            // Maximum negative: -2,147,483,648
        if(sign == 1) {
            if(result > Integer.MAX_VALUE / 10 || (result==Integer.MAX_VALUE / 10 && digit>7)) {
                return Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
        } else {
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE /10 && digit>8)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 - digit;
          }

          index++;
        }
        // sign is already applied
        return result;
    }
}