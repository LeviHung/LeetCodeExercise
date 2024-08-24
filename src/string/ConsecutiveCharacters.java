package string;

public class ConsecutiveCharacters
{
    public static int maxPower(String s) {
        char[] arr = s.toCharArray();
        char last = '\0';
        int max = 1;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == last) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
           last = arr[i];
        }
        return max;
    }

  public static void readme()
  {
    String str = "The power of the string is the maximum length of a non-empty substring that contains only one unique character.\n\n";

    str += "Given a string s, return the power of s.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ConsecutiveCharacters.readme();
    String s;
    // Input: s = "leetcode"
    // Output: 2
    s = "leetcode";
    System.out.println("maxPower(" + s + ") = " + maxPower(s));
    System.out.println("");

    // Input: s = "abbcccddddeeeeedcba"
    // Output: 5
    s = "abbcccddddeeeeedcba";
    System.out.println("maxPower(" + s + ") = " + maxPower(s));

  }

}