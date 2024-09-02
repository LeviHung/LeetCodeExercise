package recursion;

import java.util.Queue;
import java.util.LinkedList;

public class FindTheWinnerOfTheCircularGame
{
    public static int findTheWinner(int n, int k) {
        return find(n, k) + 1;
    }

    public static int find(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (k + find(n-1, k)) % n;
    }

    public static int findTheWinnerByQueue(int n, int k) {
        Queue<Integer> circle = new LinkedList<>();

        for(int i=1;i<=n;i++){
            circle.add(i);
        }

        while(circle.size()>1){
            for(int i=0;i<k-1;i++){
                circle.add(circle.remove());
            }

            circle.remove();
        }
        return circle.peek();
    }

  public static void readme()
  {
    String str = "There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.\n\n";

      str += "The rules of the game are as follows:\n\n";
      str += "Start at the 1st friend.\n\n";
      str += "Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.\n\n";
      str += "The last friend you counted leaves the circle and loses the game.\n\n";
      str += "If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.\n\n";
      str += "Else, the last friend in the circle wins the game.\n\n";
      str += "Given the number of friends, n, and an integer k, return the winner of the game.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    FindTheWinnerOfTheCircularGame.readme();

    int n;
    int k;
    // Input: n = 5, k = 2
    // Output: 3
    n = 5;
    k = 2;
    System.out.println("findTheWinner(" + n + ", " + k + ") = " + 
                       findTheWinner(n, k));

    // Input: n = 6, k = 5
    // Output: 1
    n = 6;
    k = 5;
    System.out.println("findTheWinner(" + n + ", " + k + ") = " + 
                        findTheWinner(n, k));

      System.out.println("findTheWinnerByQueue(" + n + ", " + k + ") = " + 
                         findTheWinnerByQueue(n, k));

  }
}