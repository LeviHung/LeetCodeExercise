package string;

public class BackspaceStringCompare
{
  public static boolean backspaceCompare(String s, String t) 
  {
    char[] arrayS = s.toCharArray();
    char[] arrayT = t.toCharArray();
    int indexS = arrayS.length - 1;
    int indexT = arrayT.length - 1;
    while (indexS >= 0 && indexT >= 0) {
      indexS = skipPound(arrayS, indexS);

      indexT = skipPound(arrayT, indexT);
      //System.out.println("indexS = " + indexS + ", indexT = " + indexT);
      if (indexS < 0 || indexT < 0) {
        if (indexS == indexT) {
          return true;
        } else {
          return false;
        }
      }

      if (arrayS[indexS] != arrayT[indexT]) {
        return false;
      }
      indexS--;
      indexT--;
    }

    if (indexS >= 0) {
      indexS = skipPound(arrayS, indexS);
    }
  
    if (indexT >= 0) {
      indexT = skipPound(arrayT, indexT);
    }

    if (indexS != indexT) {
        return false;
    }
    return true;
  }

  public static int skipPound(char [] array, int index)
  {
    int skipCnt = 0;
    while (array[index] == '#' || skipCnt > 0) {
      if (array[index] != '#') {
        skipCnt--;
        index--;
      } else {
        skipCnt++;
        index--;
      }
      if (index < 0) {
        break;
      }
    }
    
    return index;
  }

  public static boolean backspaceCompareEx(String s, String t) 
  {
      int left = s.length() - 1, right = t.length() - 1;
      int skipL = 0, skipR = 0;
      while (left >= 0 || right >= 0) {
          while (left >= 0) {
              if (s.charAt(left) == '#') {
                  skipL++;
                  left--;
              } else if (skipL > 0) {
                  skipL--;
                  left--;
              } else {
                  break;
              }
          }

          while (right >= 0) {
              if (t.charAt(right) == '#') {
                  skipR++;
                  right--;
              } else if (skipR > 0) {
                  skipR--;
                  right--;
              } else {
                  break;
              }
          }

          if (left >= 0 && right >= 0 && s.charAt(left) != t.charAt(right))
              return false;
          if ((left >= 0) != (right >= 0))
              return false;
          left--;
          right--;
      }
      return true;
  }
  
  public static void readme()
  {
    String str = "Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.\n\n";

    str += "Note that after backspacing an empty text, the text will continue empty.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    BackspaceStringCompare.readme();

    String s;
    String t;
    
    // s = "ab#c", t = "ad#c" => true;
    s = "ab#c";
    t = "ad#c";
    System.out.println("backspaceCompare(" + s + ", " + t + ") = " +
                       backspaceCompare(s, t));
    System.out.println("");
    
    // s = "ab##", t = "c#d#" => true
    s = "ab##";
    t = "c#d#";
    System.out.println("backspaceCompare(" + s + ", " + t + ") = " +
                       backspaceCompare(s, t));
    System.out.println("");

    // s = "a#c", t = "b" => false;
    s = "a#c";
    t = "b";
    System.out.println("backspaceCompare(" + s + ", " + t + ") = " +
                       backspaceCompare(s, t));
    System.out.println("");

    System.out.println("backspaceCompareEx(" + s + ", " + t + ") = " +
                       backspaceCompareEx(s, t));
    System.out.println("");

  }
}