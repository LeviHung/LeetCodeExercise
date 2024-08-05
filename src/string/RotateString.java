package string;

public class RotateString
{
  public static boolean rotateString(String s, String goal)
  {
    //s = "abcde", goal = "cdeab"
    // abcdeab
    // cdeabab

    // cdeabab
    // abcdeab

    if (s.length() != goal.length())
      return false;

    char [] arrayS = s.toCharArray();
    char [] arrayG = goal.toCharArray();
    for (int i = 0; i < arrayG.length; i++) {
      if (arrayS[0] == arrayG[i]) {
        int indexG = i;
        int indexS = 0;
        boolean isSame = true;
        while (indexS < arrayS.length) {
          if (arrayS[indexS] != arrayG[indexG]) {
            isSame = false;
          }
          indexS++;
          indexG++;
          if (indexG >= arrayG.length) {
            indexG = 0;
          }
        }

        if (isSame == true) {
          return true;
        }
      }
    }
    
    return false;
  }

  public static boolean rotateStringOpt(String s, String goal) 
  {
    if (s.length() != goal.length()){
      return false;
    }
    
    String concatenatedStr = s + s;
    if (concatenatedStr.contains(goal)) {
      return true;
    }
    
    return false;
  }
  
  public static void readme()
  {
    String str = "Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.\n\n";

    str += "A shift on s consists of moving the leftmost character of s to the rightmost position.\n\n";

    str += "For example, if s = \"abcde\", then it will be \"bcdea\" after one shift.\n";
    
    System.out.println(str);
  }



  public static void main()
  {
    RotateString.readme();

    String s;
    String goal;
    // s = "abcde", goal = "cdeab" => true
    s = "abcde";
    goal = "cdeab";
    
    System.out.println("rotateString(" + s + ", " + goal + ") = " +
                       rotateString(s, goal));

    // s = "abcde", goal = "abced" => false
    s = "abcde";
    goal = "abced";

    System.out.println("rotateString(" + s + ", " + goal + ") = " +
                       rotateString(s, goal));

    s = "abcdeab";
    goal = "cdeabab";

    System.out.println("rotateString(" + s + ", " + goal + ") = " +
                       rotateString(s, goal));
    System.out.println("rotateStringOpt(" + s + ", " + goal + ") = " +
                       rotateStringOpt(s, goal));

  }
}