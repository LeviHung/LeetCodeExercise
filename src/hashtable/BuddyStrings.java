package hashtable;

import java.util.Arrays;

public class BuddyStrings
{
  public static boolean buddyStrings(String s, String goal)
  {
    if (s.length() != goal.length()) {
      return false;
    }
    char[] arrayS = s.toCharArray();
    boolean [] letter = new boolean [26];

    if (s.equals(goal)) {
      for (int i = 0; i < arrayS.length; i++) {
          if (letter[arrayS[i] - 'a'] == true) {
              return true;
          }
          letter[arrayS[i] - 'a'] = true;
      }
      return false;
    }
    char[] arrayG = goal.toCharArray();

    char temp;
    int diffCnt = 0;
    int [] diff = new int [2];

    for (int i = 0; i < arrayS.length; i++) {
      if (arrayS[i] != arrayG[i]) {
        if (diffCnt >= 2) {
          return false;
        }
        diff[diffCnt] = i;
        diffCnt++;
      }
    }
    temp = arrayS[diff[0]];
    arrayS[diff[0]] = arrayS[diff[1]];
    arrayS[diff[1]] = temp;
    for (int i = 0; i < 2; i++) {
      if (arrayS[diff[i]] != arrayG[diff[i]]) {
        return false;
      }
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.\n\n";

    str += " Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].\n\n";

    str += " For example, swapping at indices 0 and 2 in \"abcd\" results in \"cbad\".\n";

    System.out.println(str);
  }

  public static void main() 
  {
    BuddyStrings.readme();

    String s;
    String goal;
    // s = "ab", goal = "ba" => true
    s = "ab";
    goal = "ba";
    System.out.println("buddyStrings(" + s + ", " + goal + ") = " + 
                       buddyStrings(s, goal));

    // s = "ab", goal = "ab" => false
    s = "ab";
    goal = "ab";
    System.out.println("buddyStrings(" + s + ", " + goal + ") = " + 
                       buddyStrings(s, goal));

    // s = "aa", goal = "aa" => true
    s = "aa";
    goal = "aa";
    System.out.println("buddyStrings(" + s + ", " + goal + ") = " + 
                       buddyStrings(s, goal));

  }
}