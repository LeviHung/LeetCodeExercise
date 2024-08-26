package string;

import java.util.StringTokenizer;

public class ReformatDate
{
    public static String reformatDate(String date) {
        int year;
        int monthNum = 0;
        int day;
        String[] monthSet = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        // String[] tokens = date.split(" ");
        String[] tokens = new String[3];
        if (date.length() == 13) {
            tokens[0] = date.substring(0,4);
            tokens[1] = date.substring(5,8);
            tokens[2] = date.substring(9,13);

        } else {
            tokens[0] = date.substring(0,3);
            tokens[1] = date.substring(4,7);
            tokens[2] = date.substring(8,12);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(tokens[2]);
        sb.append('-');

        if (tokens[1].equals(monthSet[0])) {
            sb.append("01-");
        } else if (tokens[1].equals(monthSet[1])) {
            sb.append("02-");
        } else if (tokens[1].equals(monthSet[2])) {
            sb.append("03-");
        } else if (tokens[1].equals(monthSet[3])) {
            sb.append("04-");
        } else if (tokens[1].equals(monthSet[4])) {
            sb.append("05-");
        } else if (tokens[1].equals(monthSet[5])) {
            sb.append("06-");
        } else if (tokens[1].equals(monthSet[6])) {
            sb.append("07-");
        } else if (tokens[1].equals(monthSet[7])) {
            sb.append("08-");
        } else if (tokens[1].equals(monthSet[8])) {
            sb.append("09-");
        } else if (tokens[1].equals(monthSet[9])) {
            sb.append("10-");
        } else if (tokens[1].equals(monthSet[10])) {
            sb.append("11-");
        } else if (tokens[1].equals(monthSet[11])) {
            sb.append("12-");
        }

        if (tokens[0].length() == 3) {
            sb.append('0');
            sb.append(tokens[0].charAt(0));
        } else {
            sb.append(tokens[0].charAt(0));
            sb.append(tokens[0].charAt(1));
        }

        return sb.toString();
    }

  public static void readme()
  {
    String str = "Given a date string in the form Day Month Year, where:\n\n";

    str += "Day is in the set {\"1st\", \"2nd\", \"3rd\", \"4th\", ..., \"30th\", \"31st\"}.\n\n";

    str += "Month is in the set {\"Jan\", \"Feb\", \"Mar\", \"Apr\", \"May\", \"Jun\", \"Jul\", \"Aug\", \"Sep\", \"Oct\", \"Nov\", \"Dec\"}.\n\n";
    str += "Year is in the range [1900, 2100].\n\n";
    str += "Convert the date string to the format YYYY-MM-DD, where:\n\n";
    str += "YYYY denotes the 4 digit year.\n\n";
    str += "MM denotes the 2 digit month.\n\n";
    str += "DD denotes the 2 digit day.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReformatDate.readme();
    String date;
    // Input: date = "20th Oct 2052"
    // Output: "2052-10-20"
    date = "20th Oct 2052";
    System.out.println("reformatDate(" + date + ") = " + 
                       reformatDate(date));
    System.out.println("");

      // Input: date = "6th Jun 1933"
      // Output: "1933-06-06"
      date = "6th Jun 1933";
      System.out.println("reformatDate(" + date + ") = " + 
                         reformatDate(date));
      System.out.println("");

      //Input: date = "26th May 1960"
      //Output: "1960-05-26"

      date = "26th May 1960";
      System.out.println("reformatDate(" + date + ") = " + 
                         reformatDate(date));
      System.out.println("");
  }

}