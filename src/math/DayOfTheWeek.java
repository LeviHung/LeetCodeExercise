package math;

public class DayOfTheWeek
{
  public static String dayOfTheWeek(int day, int month, int year) {
    String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", 
                           "Thursday", "Friday", "Saturday"};
    int nowYear = 2024;
    int nowMonth = 8;
    int nowDay = 18;
    int totalDays = 0;
    boolean isYesterday = true;
    if (year == nowYear) {
        if (month > nowMonth || (month == nowMonth && day > nowDay)) {
            isYesterday = false;
        } else {
            isYesterday = true;
        }
    } else if (year < nowYear) {
        isYesterday = true;
    } else {    // after
        isYesterday = false;
    }

    int startYear = 0;
    int endYear = 0;
    int firstYearDays;
    int lastYearDays;
    if (isYesterday == true) {
        startYear = year;
        endYear = nowYear - 1;
        firstYearDays = dayOfYear(day, month, year);
        lastYearDays = dayOfYear(nowDay, nowMonth, nowYear);
    } else {
        startYear = nowYear;
        endYear = year - 1;
        firstYearDays = dayOfYear(nowDay, nowMonth, nowYear);
        lastYearDays = dayOfYear(day, month, year);
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

    int index;
    if (isYesterday == true) {
        index = 7 - (totalDays % 7);
        if (index == 7) {
            index = 0;
        }
    } else {
        index = totalDays % 7;
    } 
    return daysOfWeek[index];
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

  public static boolean isLeapYear(int year) {
    if (year % 4 == 0) {
        if (year % 4000 == 0) {
            return false;
        }
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } 
        return true;
    } else {
        return false;
    }
  }

  public static String dayOfTheWeekOpt(int day, int month, int year) {

      String[] s = { "Sunday", "Monday", "Tuesday", "Wednesday",
                     "Thursday", "Friday", "Saturday" };

      int[] m = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

      int d = day;
      for (int i = 1; i < month; i++)  d += m[i];

      if (isLeapYearOpt(year) && month > 2)  d++;

      year--;
      d += (year + (year / 4) - (year / 100) + (year / 400)) % 7;

      return s[(d) % 7];
  }

  private static boolean isLeapYearOpt(int year) {
      return (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
  }
  public static void readme()
  {
    String str = "Given a date, return the corresponding day of the week for that date.\n\n";

    str += "The input is given as three integers representing the day, month and year respectively.\n\n";

    str += "Return the answer as one of the following values {\"Sunday\", \"Monday\", \"Tuesday\", \"Wednesday\", \"Thursday\", \"Friday\", \"Saturday\"}.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    DayOfTheWeek.readme();
    int day;
    int month;
    int year;
    // Input: day = 31, month = 8, year = 2019
    // Output: "Saturday"
    day = 31;
    month = 8;
    year = 2019;
    System.out.println("dayOfTheWeek(" + 
                       day + ", " + month + ", " + year + ") = " + 
                       dayOfTheWeek(day, month, year));

    // Input: day = 18, month = 7, year = 1999
    // Output: "Sunday"
    day = 18;
    month = 7;
    year = 1999;
    System.out.println("dayOfTheWeek(" + 
                       day + ", " + month + ", " + year + ") = " + 
                       dayOfTheWeek(day, month, year));

    // Input: day = 15, month = 8, year = 1993
    // Output: "Sunday"
    day = 15;
    month = 8;
    year = 1993;
    System.out.println("dayOfTheWeek(" + 
                       day + ", " + month + ", " + year + ") = " + 
                       dayOfTheWeek(day, month, year));

    System.out.println("dayOfTheWeekOpt(" + 
                       day + ", " + month + ", " + year + ") = " + 
                       dayOfTheWeekOpt(day, month, year));

  }
}