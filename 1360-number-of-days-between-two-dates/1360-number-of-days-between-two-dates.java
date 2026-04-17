class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(calculateDays(date1)- calculateDays(date2));
    }

    private int[] dayOfMonth = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    private int calculateDays(String date){
        String[] dateArray = date.split("-");
        int year = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int day = Integer.parseInt(dateArray[2]);

        // calculate year
        for(int y = 1971; y < year; y++) { //2019/1/1, only calculate 2018 for full year
        day += isLeapYear(y) ? 366 : 365;
        }

        // calculate month 2
        for(int m = 0;  m< month-1; m++) { // 2/1,calculate 1st month for full month
            day += dayOfMonth[m];
        }
        
        if(month>2 && isLeapYear(year)) { // include the 2nd month
            day+=1;
        }
        return day;
    }

    private boolean isLeapYear(int year) {
       return (year % 4 == 0 && (year % 100 !=0) || (year%400 == 0));
    }
}


// leap year: 366 dyas
// Feb 29 
// The 4-Year Rule: The year must be evenly divisible by 4.
// The 100-Year Exception: If the year is also divisible by 100, it is not a leap year.
// The 400-Year Rule: If the year is divisible by both 100 and 400, it is a leap year.