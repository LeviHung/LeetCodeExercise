package string;

public class ToLowerCase
{
  public static String toLowerCase(String s)
  {    
    char[] array = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (char ch: array) {
      if (ch > 64 && ch < 91) {
          sb.append((char) ((int)ch + 32));
      } else {
          sb.append(ch);
      }
    }
    return sb.toString();
  }

  public static String toLowerCaseOpt(String s)
  {
    return s.toLowerCase();
  }

  public static void readme()
  {
    String str = "Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ToLowerCase.readme();
    String s;
    // s = "Hello" => hello
    s = "hello";
    System.out.println("toLowerCase(" + s + ") = " + 
                       toLowerCase(s));
    
    // s = "here" => here
    s = "here";
    System.out.println("toLowerCase(" + s + ") = " + 
                       toLowerCase(s));

    // s = "LOVELY" => lovely
    s = "LOVELY";
    System.out.println("toLowerCase(" + s + ") = " + 
                       toLowerCase(s));

    System.out.println("toLowerCaseOpt(" + s + ") = " + 
                        toLowerCaseOpt(s));

    }
}