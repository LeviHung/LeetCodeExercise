package array;
import java.util.Arrays;

public class BaseballGame
{
  public static int calPoints(String[] operations)
  {
    int [] record = new int [operations.length];
    int count = 0;
    
    for (int i = 0; i < operations.length; i++) {
      if (operations[i].equals("C")){
        count--;
      } else if (operations[i].equals("D")) {
        record[count] = 2 * record[count - 1];
        count++;
      } else if (operations[i].equals("+")) {
        record[count] = record[count - 2] + record[count - 1];
        count++;
      } else {
        record[count] = Integer.valueOf(operations[i]);
        count++;
      }
    }
    
    int sum = 0;
    for (int i = 0; i < count; i++) {
      sum += record[i];
    }
    return sum;
  }

  public static void readme()
  {
    String str = "You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.\n\n";

    str += "You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:\n";

    str += "An integer x. Record a new score of x.\n\n";

    str += "'+'. Record a new score that is the sum of the previous two scores.\n\n";

    str += "'D'. Record a new score that is the double of the previous score.\n\n";

    str += "'C'. Invalidate the previous score, removing it from the record.\n\n";
    
    str += "Return the sum of all the scores on the record after applying all the operations.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    BaseballGame.readme();

    // ops = ["5","2","C","D","+"] => 30
    String [] ops1 = {"5","2","C","D","+"};
    System.out.println("calPoints(" + Arrays.toString(ops1) + ") = " +
                       calPoints(ops1));

    // ops = ["5","-2","4","C","D","9","+","+"] => 27
    String [] ops2 = {"5","-2","4","C","D","9","+","+"};
    System.out.println("calPoints(" + Arrays.toString(ops2) + ") = " +
                       calPoints(ops2));

    // ops = ["1","C"] => 0
    String [] ops3 = {"1","C"};
    System.out.println("calPoints(" + Arrays.toString(ops3) + ") = " +
                       calPoints(ops3));

  }
}