package math;

public class AddDigits
{
  public static int addDigits(int num)  
  {
    num = (num%10) +
          ((num/10) % 10) +
          ((num/100) % 10) +
          ((num/1000) % 10) +
          ((num/10000) % 10) +
          ((num/100000) % 10) +
          ((num/1000000) % 10) +
          ((num/10000000) % 10) +
          ((num/100000000) % 10) +
          ((num/1000000000) % 10);
    System.out.println("# " + num);
    num = (num % 10) + (num/10) % 10;
    System.out.println("## " + num);
    if (num >= 10) {
      num = (num % 10) + (num/10) % 10;
    }
    System.out.println("### " + num);

    return num;
  }

  public static int addDigitsR(int num) 
  {
      if (num <= 9) {
          return num;
      } 
      int add = 0;
      int rem = 0;
      while (num > 0) {
        rem = num % 10;
        add += rem;
        num = num/10;
      }
      if (add > 9) {
        return addDigits(add);
      }
      return add;
  }
  
  public static void readme()
  {
    String str = "Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.\n\n";

    str += "Could you do it without any loop/recursion in O(1) runtime?\n";
    System.out.println(str);
  }

  public static void main()
  {
    AddDigits.readme();

    int num;
    // num = 38 => 2
    num = 38;
    System.out.println("addDigits(" + num + ") = " + addDigits(num));

    // num = 0 => 0
    num = 0;
    System.out.println("addDigits(" + num + ") = " + addDigits(num));

    num = 199;
    System.out.println("addDigits(" + num + ") = " + addDigits(num));

    num = 708538619;
    System.out.println("addDigits(" + num + ") = " + addDigits(num));
  }
}