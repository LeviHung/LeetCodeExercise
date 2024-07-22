package string;

public class StudentAttendanceRecordI
{
  public static boolean checkRecord(String s) 
  {    
    int numP = 0;
    int numL = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'P') {
        numL = 0;
      } else if (s.charAt(i) == 'A') {
        numP++;
        if (numP >= 2) {
          return false;
        }
        numL = 0;
      } else {
        numL++;
        if (numL >= 3) {
          return false;
        }
      }
    }
    return true;
  }

  public static void readme()
  {
    String str = "You are given a string s representing an attendance record for a student where each character signifies whether the student was\n";

    str += "The student is eligible for an attendance award if they meet both of the following criteria:\n\n";

    str += "The student was absent ('A') for strictly fewer than 2 days total.\n\n";

    str += "The student was never late ('L') for 3 or more consecutive days.\n\n";

    str += "Return true if the student is eligible for an attendance award, or false otherwise.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    StudentAttendanceRecordI.readme();

    String s;

    // s = "PPALLP" => true
    s = "PPALLP";
    System.out.println("checkRecord(" + s + ") = " + 
                       checkRecord(s));

    // s = "PPALLL" => false
    s = "PPALLL";
    System.out.println("checkRecord(" + s + ") = " + 
                       checkRecord(s));
    }
}