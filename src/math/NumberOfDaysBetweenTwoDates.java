package math;

public class NumberOfDaysBetweenTwoDates
{
    public static int daysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));
        int day2 = Integer.parseInt(date2.substring(8, 10));
        boolean isYesterdayData1 = false;
        int totalDays = 0;

        if (year1 == year2) {
            if (month1 > month2 || (month1 == month2 && day1 > day2)) {
                isYesterdayData1 = false;
            } else {
                isYesterdayData1 = true;
            }
        } else if (year1 < year2) {
            isYesterdayData1 = true;
        } else {    // after
            isYesterdayData1 = false;
        }

        int startYear = 0;
        int endYear = 0;
        int firstYearDays;
        int lastYearDays;
        if (isYesterdayData1 == true) {
            startYear = year1;
            endYear = year2 - 1;
            firstYearDays = dayOfYear(day1, month1, year1);
            lastYearDays = dayOfYear(day2, month2, year2);
        } else {
            startYear = year2;
            endYear = year1 - 1;
            firstYearDays = dayOfYear(day2, month2, year2);
            lastYearDays = dayOfYear(day1, month1, year1);
        }

        int fullYearDays = 0;
        for (int i = startYear; i <= endYear; i++) {
            if (isLeapYear(i) == true) {
                fullYearDays += 366;
            } else {
                fullYearDays += 365;
            }
        }
        totalDays = lastYearDays + fullYearDays - firstYearDays;
        return totalDays;
    }

    public static int dayOfYear(int day, int month, int year) {
        int res = 0;
        int[] months = new int [] {0, 31, 59, 90, 120, 151, 181, 
                                212, 243, 273, 304, 334, 365};
        if (month < 3) {
            res = months[month - 1] + day; 
        }

        int[] months_leap = new int [] {0, 31, 60, 91, 121, 152, 182, 
                                        213, 244, 274, 305, 335, 366};
        if (isLeapYear(year) == true) {
            res = months_leap[month - 1] + day;
        } else {
            res = months[month - 1] + day; 
        }
        return res;
    }

    public static boolean isLeapYear(int y) {
        if (y % 4 != 0) {
            return false;
        } else {
            if (y % 4000 == 0)
                return false;
            else if (y % 100 == 0 && y % 400 != 0)
                return false;
            else 
                return true;
        }
    }

    public static int daysBetweenDatesOpt(String date1, String date2) {
        return Math.abs(calculateDaysInDateStr(date1) - calculateDaysInDateStr(date2));
    }


    private static int calculateDaysInDateStr(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int days = (year - 1) * 365 + ((year - 1) / 4 - ((year - 1) / 100) + ((year - 1) / 400));

        for (int i = 1; i < month; i++) {
            switch (i) {
                case 2:
                    if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0))
                        days += 29;
                    else days += 28;
                    break;
                case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                    days +=31;
                    break;
                default:
                    days +=30;
            }
        }
        days += day;
        return days;
    }
    
  public static void readme()
  {
    String str = "Write a program to count the number of days between two dates.\n\n";

    str += "The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfDaysBetweenTwoDates.readme();

    String date1;
    String date2;
    // Input: date1 = "2019-06-29", date2 = "2019-06-30"
    // Output: 1
    date1 = "2019-06-29"; 
    date2 = "2019-06-30";
    System.out.println("daysBetweenDates(" + date1 + ", " + date2 + ") = " + 
                       daysBetweenDates(date1, date2));

    // Input: date1 = "2020-01-15", date2 = "2019-12-31"
    // Output: 15
    date1 = "2020-01-15"; 
    date2 = "2019-12-31";
    System.out.println("daysBetweenDates(" + date1 + ", " + date2 + ") = " + 
                       daysBetweenDates(date1, date2));

    System.out.println("daysBetweenDatesOpt(" + date1 + ", " + date2 + ") = " + 
         daysBetweenDatesOpt(date1, date2));

    }
}