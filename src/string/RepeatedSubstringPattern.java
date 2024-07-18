package string;

import java.util.List;
import java.util.Arrays;

public class RepeatedSubstringPattern
{
  public static boolean repeatedSubstringPattern(String s)
  {
    // s = "abab" => true
    int lenS = s.length();
    String str = "";
    String sub = "";
    int num = 1;
    while (num <= lenS / 2) {
      str = s.substring(0, num);
      //System.out.println("str = " + str);
      for (int i = num; i <= lenS - num; i = i + num) {
        sub = s.substring(i, i + num);
        //System.out.println("sub = " + sub);
        if (str.equals(sub) == false) {
          break;
        } else {
          //System.out.println("equals, i = " + i + ", num = " + num);
          if (i == lenS - num) {
            return true;
          }
        }
      }
      num++;
    }
    return false;
  }

  static Integer[] primes = new Integer[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
    79, 83, 89, 97, 101, 103, 107, 109, 113 };

  public static boolean repeatedSubstringPatternOpt(String s) 
  {
    List<Integer> primeNumbers = Arrays.asList(primes);
    int n = s.length();

  for (Integer prime : primeNumbers) {
    int size = n / prime;
    if (size < 1) {
        return false;
    }
    if (n % size == 0) {
        boolean sol = true;
        String substring = s.substring(0, size);
        for (int i = 1; size * (i + 1) <= s.length(); i++) {
            String part = s.substring(size * i, size * (i + 1));
            if (!substring.equals(part)) {
                sol = false;
                break;
            }
        }
        if (sol == true) {
            return true;
        }
    }
  }

  return false;
  }
  
  public static void readme()
  {
    String str = "Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    RepeatedSubstringPattern.readme();

    // s = "abab" => true
    String s = "abab";
    System.out.println("repeatedSubstringPattern(" + s + ") = " + 
                       repeatedSubstringPattern(s));

    // s = "aba" => false
    s = "aba"; 
    System.out.println("repeatedSubstringPattern(" + s + ") = " + 
                       repeatedSubstringPattern(s));

    // s = "abcabcabcabc" => true;
    s = "abcabcabcabc";
    System.out.println("repeatedSubstringPattern(" + s + ") = " + 
                        repeatedSubstringPattern(s));

    // s = "abcabcabcabc" => true;
    s = "bb";
    System.out.println("repeatedSubstringPattern(" + s + ") = " + 
                        repeatedSubstringPattern(s));

    System.out.println("repeatedSubstringPatternOpt(" + s + ") = " + 
                        repeatedSubstringPatternOpt(s));

  }
}