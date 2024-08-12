package twopointers;

import java.util.StringTokenizer;

public class ReverseOnlyLetters
{
  public static String reverseOnlyLetters(String s)
  {    
    StringBuilder sb = new StringBuilder();
    char[] array = s.toCharArray();
    int right = array.length - 1;

    // -abcd-
    for (char ch: array) {
      if (isEngLetter(ch)) {
        while (isEngLetter(array[right]) == false) {
          right--;
          if (right == 0) {
            break;
          }
        }
        sb.append(array[right]);
        right--;

      } else {
        sb.append(ch);
      }
    }
    
    return sb.toString();
  }

  public static boolean isEngLetter(char ch) {
    if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
      return true;
    } else {
      return false;
    }
  }

  public static void readme()
  {
    String str = "Given a string s, reverse the string according to the following rules:\n\n";
    
    str += "All the characters that are not English letters remain in the same position.\n\n";
    str += "All the English letters (lowercase or uppercase) should be reversed.\n\n";
    str += "Return s after reversing it.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReverseOnlyLetters.readme();
    String s;
    // s = "ab-cd" => "dc-ba"
    s = "ab-cd";
    System.out.println("reverseOnlyLetters(" + s + ") = " + 
                       reverseOnlyLetters(s));
    System.out.println("");

    //  s = "a-bC-dEf-ghIj" => "j-Ih-gfE-dCba"
    s = "a-bC-dEf-ghIj";
    System.out.println("reverseOnlyLetters(" + s + ") = " + 
                       reverseOnlyLetters(s));
    System.out.println("");

    // s = "Test1ng-Leet=code-Q!" => "Qedo1ct-eeLg=ntse-T!"
    s = "Test1ng-Leet=code-Q!";
    System.out.println("reverseOnlyLetters(" + s + ") = " + 
                       reverseOnlyLetters(s));
    System.out.println("");

  }

}