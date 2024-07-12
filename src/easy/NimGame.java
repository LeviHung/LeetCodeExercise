package easy;

public class NimGame
{
  public static boolean canWinNim(int n)
  {
    if ( n % 4 == 0) {
      return false;
    } else {
      return true;
    }
  }

  public static void readme()
  {
    String str = "You are playing the following Nim Game with your friend:\n\n";

    str += "Initially, there is a heap of stones on the table.\n\n";

    str += "You and your friend will alternate taking turns, and you go first.\n\n";

    str += "On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.\n\n";

    str += "The one who removes the last stone is the winner.\n\n";

    str += "Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    NimGame.readme();
    int n;
    // n = 4 => false
    n = 4;
    System.out.println("canWinNim(" + n + ") = " + canWinNim(n));

    // n = 1 => true
    n = 1;
    System.out.println("canWinNim(" + n + ") = " + canWinNim(n));

    // n = 2 => true
    n = 2;
    System.out.println("canWinNim(" + n + ") = " + canWinNim(n));
  }
}