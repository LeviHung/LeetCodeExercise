package string;

import java.util.Arrays;

public class ReverseString
{
  public static void reverseString(char[] s)
  {    
    int l = 0;
    int r = s.length - 1;
    char tmp = '\0';
    while (l < r) {
      tmp = s[l];
      s[l] = s[r];
      s[r] = tmp;
      l++;
      r--;
    }
  }

  public static void readme()
  {
    String str = "Write a function that reverses a string. The input string is given as an array of characters s.\n\n";

    str += "You must do this by modifying the input array in-place with O(1) extra memory.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReverseString.readme();

    // s = ["h","e","l","l","o"] => ["o","l","l","e","h"]
    char[] s1 = {'h','e','l','l','o'};
    System.out.println("reverseString(" + Arrays.toString(s1) + ") = ");
    reverseString(s1);
    System.out.println(Arrays.toString(s1));

    // s = ["H","a","n","n","a","h"] => ["h","a","n","n","a","H"]
    char[] s2 = {'H','a','n','a','h'};
    System.out.println("reverseString(" + Arrays.toString(s2) + ") = ");
    reverseString(s2);
    System.out.println(Arrays.toString(s2));

  }

}