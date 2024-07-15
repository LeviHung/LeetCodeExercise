package math;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberHigherLower
{
  private static int number;
  public static int guessNumber(int n)
  {
      // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
      Random rand = new Random();
      if (n == 2126753390) {
        number = 1702766719;
      } else {
        number = 6; //rand.nextInt(n + 1);
      }
      
      int input = 0;
      int result = -1;
      int l = 1;
      int r = n;
      input = r;
      while (result != 0 ) {
        result = guess(input);

        if (result == -1) {
          r = input - 1;
          if (l == r) {
            input = l;
          } else {
            input = input - (input - l) / 2;
          }
        } else if (result == 1) {
          l = input + 1;
          if (l == r) {
            input = l;
          } else {
            input = input + (r - input) / 2;
          }
        }
      }
      
      return input;
  }
    
  /*
   * @param  num   your guess
   * @return 	     -1 if num is higher than the picked number
   *			      1 if num is lower than the picked number
   *               otherwise return 0
   */
  public static int guess(int num)
  {
     if (num > number) {
       return -1;

     } else if (num < number) {
       return 1;

     } else {
       return 0;
     }
  }
    
  public static void readme()
  {
    String str = "We are playing the Guess Game. The game is as follows:\n\n";

    str += "I pick a number from 1 to n. You have to guess which number I picked.\n\n";

    str += "Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.\n\n";

    str += "You call a pre-defined API int guess(int num), which returns three possible results:\n\n";
    str += "-1: Your guess is higher than the number I picked (i.e. num > pick).\n\n";
    str += "1: Your guess is lower than the number I picked (i.e. num < pick).\n\n";
    str += "0: your guess is equal to the number I picked (i.e. num == pick).\n\n";

    str += "Return the number that I picked.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
        GuessNumberHigherLower.readme();

    int num;
    num = 10;
    System.out.println("guessNumber(" + num + ") = " + guessNumber(num));

    num = 2126753390;
    System.out.println("guessNumber(" + num + ") = " + guessNumber(num));
  }
}