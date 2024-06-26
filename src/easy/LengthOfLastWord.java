package easy;

public class LengthOfLastWord
{
  public static int lengthOfLastWord(String s) 
  {
    // Use string method, but the runtime is the seond place.
    /* 
    String[] myArray = s.split(" ");
    return myArray[myArray.length - 1].length();
    */
    int num = 0;
    boolean found = false;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ' && found) {
        return num;
      } else if (s.charAt(i) != ' ') {
        found = true;
        num++;
      }
    }

    return num;
  }


  public static void readme()
  {
    String str = "Given a string s consisting of words and spaces, return the length of the last word in the string.\n\n";

    str += "A word is a maximal substring consisting of non-space characters only.\n";

    System.out.println(str);
  }
}