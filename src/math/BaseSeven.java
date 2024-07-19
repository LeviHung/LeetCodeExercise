package math;

public class BaseSeven
{
  public static String convertToBase7(int num)
  {
    StringBuilder sb = new StringBuilder();
    boolean isNegative = false;
    
    if (num == 0) {
      return "0";
    }

    if (num < 0) {
      isNegative = true;
      num = 0 - num;      
    }
    
    while (num > 0) {
      sb.append(num % 7);
      num = num/7;
    }

    if (isNegative == true) {
      sb.append('-');
    }
    
    return sb.reverse().toString();
  }

  public static String convertToBase7Opt(int num) {
      return Integer.toString(num,7);
  }
  
  public static void readme()
  {
    String str = "Given an integer num, return a string of its base 7 representation.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    BaseSeven.readme();

    int num;
    // num = 100 => "202"
    num = 100;
    System.out.println("convertToBase7(" + num + ") = " + 
                       convertToBase7(num));

    // num = -7 => "-10"
    num = -7;
    System.out.println("convertToBase7(" + num + ") = " + 
                       convertToBase7(num));
    
    System.out.println("convertToBase7Opt(" + num + ") = " + 
                        convertToBase7Opt(num));

  }
}