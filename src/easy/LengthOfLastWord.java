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

  public static void main()
  {
    LengthOfLastWord.readme();

    // s = "Hello World" => 5
    String s = "Hello World";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
                       LengthOfLastWord.lengthOfLastWord(s));

    // s = "   fly me   to   the moon  " => 4
    s = "   fly me   to   the moon  ";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));

    // s = "luffy is still joyboy" => 6
    s = "luffy is still joyboy";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));

    s = "a";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));
  }
}