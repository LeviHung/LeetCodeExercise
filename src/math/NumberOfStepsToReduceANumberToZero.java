package math;

public class NumberOfStepsToReduceANumberToZero
{
  public static int numberOfSteps(int num) {
      int res = 0;
      while (num > 0) {
          if (num % 2 == 0) {
              num = num / 2;
          } else {
              num = num - 1;
          }
          res++;
      } 
      return res;
  }

  public static void readme()
  {
    String str = "Given an integer num, return the number of steps to reduce it to zero.\n\n";

    str += "In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    NumberOfStepsToReduceANumberToZero.readme();

    int num;
    // Input: num = 14
    // Output: 6

    num = 14;
    System.out.println("numberOfSteps(" + num + ") = " + numberOfSteps(num));

    // Input: num = 8
    // Output: 4

    num = 8;
    System.out.println("numberOfSteps(" + num + ") = " + numberOfSteps(num));

  }
}