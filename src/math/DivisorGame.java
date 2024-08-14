package math;

public class DivisorGame
{
  public static boolean divisorGame(int n) 
  {
    if (n % 2 == 0)
      return true;
    else 
      return false;
  }
  /*
  The base cases that we have are:
  
  If N == 1, you always lose.
  If N == 2, you can pick x = 1 which leaves a remainder of 1 for the other person that will make them lose. Hence, you win.
  Now extending those base cases, we have:
  
  If N is an odd number, any factor x of N where N % x == 0 will always be odd. Since x is odd, the remainder we get N - x will always be even. (Subtracting an odd number from another odd number aways leaves an even number as the remainder.)
  
  If N is an even number, we can make the remainder being passed to the other player as odd by just choosing x = 1.
  Going by the above logic, if N is even, we can always pass the other player an odd number. And if N is odd, we can only pass an even numer as the remainder to the other player. This ultimately leads us to the base case of passing to the other player either N == 1 where we win or N == 2 where we lose.
  
  So if N is even, we can always make the other player get a 1 ultimately which means, we can always win if N is even. Conversely, if N is odd, we can never make the other player get a 1, which means we always lose.
  */

  public static void readme()
  {
    String str = "Alice and Bob take turns playing a game, with Alice starting first.\n\n";

    str += "Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:\n\n";
    str += "Choosing any x with 0 < x < n and n % x == 0.\n\n";
    str += "Replacing the number n on the chalkboard with n - x.\n\n";
    str += "Also, if a player cannot make a move, they lose the game.\n\n";
    str += "Return true if and only if Alice wins the game, assuming both players play optimally.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DivisorGame.readme();

    int n;
    // n = 2 => true
    n = 2;
    System.out.println("divisorGame(" + n + ") = " + divisorGame(n));

    // n = 3 => false
    n = 3;
    System.out.println("divisorGame(" + n + ") = " + divisorGame(n));

  }
}