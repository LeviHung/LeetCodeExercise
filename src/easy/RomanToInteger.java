package easy;

public class RomanToInteger
{
  public static int romanToInt(String s)
  {
    int num = 0;

    for (int i = 0; i < s.length(); i++) {
      switch (s.charAt(i)) {
        case 'M':
          num += 1000;
          break;
        case 'D':
          num += 500;
          break;
        case 'C':
          if ((i != s.length() - 1) && 
              (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D')) {
            num -= 100;
          } else {
            num += 100;
          }
          break;
        case 'L':
          num += 50;
          break;
        case 'X':
          if ((i != s.length() - 1) && 
              (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
            num -= 10;
          } else {
            num += 10;
          }
          break;
        case 'V':
          num += 5;
          break;
        case 'I':
          if ((i != s.length() - 1) && 
              (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
            num -= 1;
          } else {
            num += 1;
          }
          break;
        default:
          System.out.println("Invalid Character!");
          break;
      }
    }
      //MCMXCIV: 1994
    return num;
  }

  public static void readme()
  {
    String str = "Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.\n\n";

    str += "Symbol       Value\n";
    str += "I             1\n";
    str += "V             5\n";
    str += "X             10\n";
    str += "L             50\n";
    str += "C             100\n";
    str += "D             500\n";
    str += "M             1000\n\n";
    str += "For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.\n\n";

    str += "Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:\n\n";

    str += "I can be placed before V (5) and X (10) to make 4 and 9.\n";
    str += "X can be placed before L (50) and C (100) to make 40 and 90.\n"; 
    str += "C can be placed before D (500) and M (1000) to make 400 and 900.\n";
    str += "Given a roman numeral, convert it to an integer.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RomanToInteger.readme();

    System.out.println("romanToInt(\"XXVII\") = " + 
                       RomanToInteger.romanToInt("XXVII"));
    System.out.println("romanToInt(\"MCMXCIV\") = " + 
                       RomanToInteger.romanToInt("MCMXCIV"));
  }

}