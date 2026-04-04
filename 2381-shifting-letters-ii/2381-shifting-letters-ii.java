class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n];


        // Build difference aray
        for(int[] shift : shifts) {
            if(shift[2] == 1) {
                diffArray[shift[0]]++;
                if(shift[1]+1 < n) {
                    diffArray[shift[1]+1]--;
                }
            } else {
                diffArray[shift[0]]--;
                if(shift[1] + 1 < n) {
                    diffArray[shift[1]+1]++;
                }
            }
        }

        int numberOfShifts = 0;
        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + diffArray[i]) % 26;
            // correction for negative result
            if(numberOfShifts < 0) numberOfShifts += 26;

            //Calculate the new character by shifting s[i]
            //use 'a' + 转回字符
            char shiftedChar = (char)('a'+((s.charAt(i) - 'a' + numberOfShifts) % 26));

            result.setCharAt(i, shiftedChar);
        }

        return result.toString();

    }
}