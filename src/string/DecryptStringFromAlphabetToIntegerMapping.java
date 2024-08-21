package string;

import java.util.StringTokenizer;

public class DecryptStringFromAlphabetToIntegerMapping
{
  public static String freqAlphabets(String s) {
      StringBuilder sb = new StringBuilder();
      char[] arr = s.toCharArray();
      int numCh = 0;
      for (int i = arr.length - 1; i >= 0; i--) {
          if (arr[i] == '#') {
              numCh = (int)(arr[i-1] - '0') + (int)(arr[i-2] - '0') * 10 - 1;
              sb.append((char) ('a'+ numCh)); 
              i = i - 2;
          } else {
              numCh = (int)(arr[i] - '0') - 1;
              sb.append((char) ('a'+ numCh));
          }
      }
      return sb.reverse().toString();
  }

  public static void readme()
  {
    String str = "You are given a string s formed by digits and '#'. We want to map s to English lowercase characters as follows:\n\n";

    str += "Characters ('a' to 'i') are represented by ('1' to '9') respectively.\n\n";
    
    str += "Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.\n\n";
    
    str += "Return the string formed after mapping.\n\n";

    str += "The test cases are generated so that a unique mapping will always exist.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    DecryptStringFromAlphabetToIntegerMapping.readme();
    String s;
    // Input: s = "10#11#12"
    // Output: "jkab"



    s = "10#11#12";
    System.out.println("freqAlphabets(" + s + ") = " + 
                       freqAlphabets(s));
    System.out.println("");

    // Input: s = "1326#"
    // Output: "acz"

    s = "1326#";
    System.out.println("freqAlphabets(" + s + ") = " + 
                       freqAlphabets(s));

  }

}