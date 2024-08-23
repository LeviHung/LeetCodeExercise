package hashtable;

import java.util.Arrays;

public class IncreasingDecreasingString
{
  public static String sortString(String s) {
      char[] arr = s.toCharArray();
      int[] freq = new int [26];
      for (char ch: arr) {
          freq [ch - 'a']++;
      }

      int size = 0; 
      StringBuilder sb = new StringBuilder();
      int index;
      while (size < arr.length) {
          for (index = 0; index < 26; index++) {
              if (freq[index] > 0) {
                  sb.append((char) (index + 'a'));
                  freq[index]--;
                  size++;
              } 
          }

          for (index = 25; index >= 0; index--) {
              if (freq[index] > 0) {
                  sb.append((char) (index + 'a'));
                  freq[index]--;
                  size++;
              } 
          }
      }
      return sb.toString();
  }

  public static void readme()
  {
    String str = "You are given a string s. Reorder the string using the following algorithm:\n\n";

    str += "Pick the smallest character from s and append it to the result.\n\n";
    str += "Pick the smallest character from s which is greater than the last appended character to the result and append it.\n\n";
    str += "Repeat step 2 until you cannot pick more characters.\n\n";
    str += "Pick the largest character from s and append it to the result.\n\n";
    str += "Pick the largest character from s which is smaller than the last appended character to the result and append it.\n\n";
    str += "Repeat step 5 until you cannot pick more characters.\n\n";
    str += "Repeat the steps from 1 to 6 until you pick all characters from s.\n\n";
    str += "In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.\n\n";
    str += "Return the result string after sorting s with this algorithm.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    IncreasingDecreasingString.readme();
    String s;
    
    // Input: s = "aaaabbbbcccc"
    // Output: "abccbaabccba"
    s = "aaaabbbbcccc";
    System.out.println("sortString(" + s + ") = " + 
                       sortString(s));

    // Input: s = "rat"
    // Output: "art"
    s = "rat";
    System.out.println("sortString(" + s + ") = " + 
                       sortString(s));

  }
}