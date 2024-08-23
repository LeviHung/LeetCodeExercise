package string;

import java.util.StringTokenizer;
import java.util.Arrays;

public class GenerateAStringWithCharacterHaveOddCounts
{
  public static String generateTheString(int n) {
    String s = "a";
    s = s.repeat(n-1);
    if (n%2 == 0) 
        s = s + "b";
    else 
        s = s + "a";
        return s;
    /*
    StringBuilder sb = new StringBuilder(s);
    char [] ch = new char [n - 1];
    Arrays.fill(ch, 0, n-1, 'a');
    sb.append(ch);

    if (n % 2 == 0) {
        sb.append('b');
    } else {
        sb.append('a');
    }
    return sb.toString();
    */
  }

  public static String generateTheStringOpt(int n) {
    var result = new char[n];
    Arrays.fill(result, 'a');       
    if (n % 2 == 0) result[0] = 'b';
    return new String(result);
  }

  public static void readme()
  {
    String str = "Given an integer n, return a string with n characters such that each character in such string occurs an odd number of times.\n\n";
    
    str += "The returned string must contain only lowercase English letters. If there are multiples valid strings, return any of them.  \n";

    System.out.println(str);
  }

  public static void main() 
  {
    GenerateAStringWithCharacterHaveOddCounts.readme();
    int n;
    // Input: n = 4
    // Output: "pppz"
    n = 4;
    System.out.println("generateTheString(" + n + ") = " + 
                       generateTheString(n));
    System.out.println("");

    // Input: n = 2
    // Output: "xy"
    n = 2;
    System.out.println("generateTheString(" + n + ") = " + 
                       generateTheString(n));
    System.out.println("");

    // Input: n = 7
    // Output: "holasss"
    n = 7;
    System.out.println("generateTheString(" + n + ") = " + 
                       generateTheString(n));


  }

}