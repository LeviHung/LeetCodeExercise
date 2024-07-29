package string;

import java.util.Arrays;
public class RobotReturnToOrigin
{
  public static boolean judgeCircle(String moves)
  {    
    char [] array = moves.toCharArray();
    int x = 0;
    int y = 0;
    int d = 0;  // 0: E, 1: W, 2: S:, 3: N
    
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 'U') {
        y++;
      } else if (array[i] == 'D') {
        y--;
      } else if (array[i] == 'R') {
        x++;
      } else if (array[i] == 'L') {
        x--;
      }
      /*
      if (array[i] == 'U') {
        y++;
        d = 3;
      } else if (array[i] == 'D') {
        y--;
        d = 2;
      } else if (array[i] == 'R') {
        if (d == 0) {
          d = 2;
          y--;
        } else if (d == 1) {
          d = 3;
          y++;
        } else if (d == 2) {
          d = 1;
          x--;
        } else {
          d = 0;
          x++;
        }

      } else if (array[i] == 'L') {
        if (d == 0) {
          d = 3;
          y++;
        } else if (d == 1) {
          d = 2;
          y--;
        } else if (d == 2) {
          d = 0;
          x++;
        } else {
          d = 1;
          x--;
        }
      }
      */
    }

    if (x == 0 && y == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean judgeCircleOpt(String moves) {

      int[] arr = new int[26];

      for(char ch : moves.toCharArray()){
          arr[ch - 'A']++;
      }

      return (arr['D' - 'A'] == arr['U' - 'A'] && 
              arr['L' - 'A'] == arr['R' - 'A']);
  }
  
  public static void readme()
  {
    String str = "There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.\n\n";

    str += "You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).\n\n";

    str += "Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.\n\n";

    str += "Note: The way that the robot is \"facing\" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RobotReturnToOrigin.readme();

    String moves;
    // moves = "UD" => true
    moves = "UD";
    System.out.println("judgeCircle(" + moves + ") = " + 
                       judgeCircle(moves));

    // moves = "LL" => false
    moves = "LL";
    System.out.println("judgeCircle(" + moves + ") = " + 
                       judgeCircle(moves));

    moves = "RLUURDDDLU";
    System.out.println("judgeCircle(" + moves + ") = " + 
                       judgeCircle(moves));
    
    System.out.println("judgeCircleOpt(" + moves + ") = " + 
                       judgeCircleOpt(moves));

  }
}