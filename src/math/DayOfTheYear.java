package math;

public class DayOfTheYear
{
  public static int dayOfYear(String date) {
    /*
    String[] tokens = date.split("-");
    int year = Integer.parseInt(tokens[0]);
    int month = Integer.parseInt(tokens[1]);
    int day = Integer.parseInt(tokens[2]);
    */
    int res = 0;
    char[] arr = date.toCharArray();
    int month = (arr[5] - '0') * 10 +  (arr[6] - '0');
    int day = (arr[8] - '0') * 10 +  (arr[9] - '0');

    int[] months = new int [] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    if (month < 3) {
        res = months[month - 1] + day; 
    }

    int year = (arr[0] - '0') * 1000 +  (arr[1] - '0') * 100 +  (arr[2] - '0') * 10 +  (arr[3] - '0');
    int[] months_leap = new int [] {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
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

  public static int dayOfYearOpt(String date) {

      int month = 10 * date.charAt(5) + date.charAt(6) - 528, day = 10 * date.charAt(8) + date.charAt(9) - 528;

      // fast return if we don't need leap years
      if (month <= 2) return day + (1 - month >>> 27);

      // months between
      day += 30 * month + month / 2 - 32 + ((month - 1 >> 3) & month);

      // leap year
      int yearPart = 10 * date.charAt(2) + date.charAt(3) - 528;
      if (yearPart == 0) yearPart = 10 * date.charAt(0) + date.charAt(1) - 528;

      return day + (((yearPart & 3) - 1) >>> 31);
  }

  public static void readme()
  {
    String str = "Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    DayOfTheYear.readme();
    String date = "";

    // Input: date = "2019-01-09"
    // Output: 9
    date = "2019-01-09";
    System.out.println("dayOfYear(" + date + ") = " + 
                       dayOfYear(date));


    // Input: date = "2019-02-10"
    // Output: 41
    date = "2019-02-10";
    System.out.println("dayOfYear(" + date + ") = " + 
                       dayOfYear(date));
    System.out.println("dayOfYearOpt(" + date + ") = " + 
                       dayOfYearOpt(date));

  }
}