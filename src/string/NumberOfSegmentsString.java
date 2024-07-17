package string;

import java.util.StringTokenizer;

public class NumberOfSegmentsString
{
  public static int countSegments(String s)
  {    
    int lenS = s.length();
    int index = 0;
    char space = ' ';
    int count = 0;
    while (index < lenS) {
      int i = s.indexOf(space, index);
      if (i > index) {
        index = i + 1;
        count++;
      } else if (i == -1) {
        index = lenS;
        count++;
      } else {    // i = index => continous space
        index = i + 1;
      }
    }
    return count;
  }

  public static int countSegmentsOpt(String s) 
  {
    if (s.length() == 0) {
      return 0;
    }
      
    StringTokenizer word = new StringTokenizer(s);
  
    return word.countTokens();
  }

  public static void readme()
  {
    String str = "Given a string s, return the number of segments in the string.\n\n";

    str += "A segment is defined to be a contiguous sequence of non-space characters.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfSegmentsString.readme();

    // s = "Hello, my name is John" => 5
    String s;
    s = "Hello, my name is John";
    System.out.println("countSegments(" + s + ") = " + 
                       countSegments(s));

    // s = "Hello" => 1
    s = "Hello";
    System.out.println("countSegments(" + s + ") = " + 
                       countSegments(s));

    s = "     ";
    System.out.println("countSegments(" + s + ") = " + 
                       countSegments(s));

    s = "The one-hour drama series Westworld is a dark odyssey about the dawn of artificial consciousness and the evolution of sin. Set at the intersection of the near future and the reimagined past, it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";

    System.out.println("countSegments(" + s + ") = " + 
                        countSegments(s));

    }
}